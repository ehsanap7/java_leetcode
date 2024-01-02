package tree;

import java.util.Stack;

class T104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        int ans = 0;

        while (!stack.empty()) {
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            int depth = pair.depth;

            ans = Math.max(ans, depth);
            if (node.left != null) {
                stack.push(new Pair(node.left, depth + 1));
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, depth + 1));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        T104 t104 = new T104();

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);

        System.out.println("Max depth: " + t104.maxDepth(root));
    }

}
