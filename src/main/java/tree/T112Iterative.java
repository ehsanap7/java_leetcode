package tree;

import java.util.Stack;

public class T112Iterative {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        Stack<Pair> stack = new Stack<>();

        stack.push(new Pair(root, root.val));

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            int curr = pair.depth;

            if (node.left != null) {
                stack.push(new Pair(node.left, curr + node.left.val));
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, curr + node.right.val));
            }

            if (node.left == null && node.right == null && curr == targetSum) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        T112Iterative t112 = new T112Iterative();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(t112.hasPathSum(root, 22));
    }

}
