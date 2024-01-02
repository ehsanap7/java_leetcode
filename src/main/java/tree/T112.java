package tree;

public class T112 {

    int target = 0;

    public boolean dfs(TreeNode root, int curr) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return (curr + root.val) == target;
        }

        curr += root.val;
        boolean left = dfs(root.left, curr);
        boolean right = dfs(root.right, curr);

        return left || right;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        return dfs(root, 0);
    }

    public static void main(String[] args) {
        T112 t112 = new T112();

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
