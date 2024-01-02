package tree;

import java.util.Stack;

public class T1448Iterative {

    public int goodNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int ans = 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, Integer.MIN_VALUE));

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            int maxLine = pair.depth;

            if (node.left != null) {
                stack.push(new Pair(node.left, Math.max(maxLine, node.val)));
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, Math.max(maxLine, node.val)));
            }

            if (node.val >= maxLine) {
                ans += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        T1448Iterative t1448 = new T1448Iterative();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(t1448.goodNodes(root));
    }

}
