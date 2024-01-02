package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public void printAllNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodesInCurrentLevel = queue.size();
            // do some logic here for the current level

            for (int i = 0; i < nodesInCurrentLevel; i++) {
                TreeNode node = queue.remove();

                // do some logic here on the current node
                System.out.println(node.val);

                // put the next level onto the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ans = new ArrayList<>();

        if(root==null){
            return new ArrayList<>();
        }

        while(!queue.isEmpty()){
            int sizeCurr = queue.size();
            int temp = 0;
            for(int i=0 ; i < sizeCurr ; i++){
                TreeNode curr = queue.remove();
                temp = curr.val;
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;

        while(!queue.isEmpty()){
            int currSize = queue.size();
            ans = 0;
            for(int i = 0; i<currSize; i++){
                TreeNode node = queue.remove();
                ans += node.val;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return ans;
    }

    public List<Integer> largestValues(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ans = new ArrayList<>();

        while(!queue.isEmpty()){
            int queueSize = queue.size();
            int maxCurr = Integer.MIN_VALUE;
            for(int i = 0 ; i < queueSize ; i++){
                TreeNode node = queue.remove();
                maxCurr = Math.max(maxCurr, node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            ans.add(maxCurr);
        }
        return ans;
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();

        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
////        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode(1);

        bfs.rightSideView(root);
    }

}
