package tree;

public class T1448 {

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode node, int maxLine){
        if(node == null){
            return 0;
        }

        int left = dfs(node.left, Math.max(maxLine, node.val));
        int right = dfs(node.right, Math.max(maxLine, node.val));
        int ans = left + right;
        if(node.val >= maxLine){
            ans += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        T1448 t1448 = new T1448();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(t1448.goodNodes(root));
    }

}
