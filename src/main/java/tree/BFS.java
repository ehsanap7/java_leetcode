package tree;

import java.util.*;

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

        if (root == null) {
            return new ArrayList<>();
        }

        while (!queue.isEmpty()) {
            int sizeCurr = queue.size();
            int temp = 0;
            for (int i = 0; i < sizeCurr; i++) {
                TreeNode curr = queue.remove();
                temp = curr.val;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
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

        while (!queue.isEmpty()) {
            int currSize = queue.size();
            ans = 0;
            for (int i = 0; i < currSize; i++) {
                TreeNode node = queue.remove();
                ans += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return ans;
    }

    public List<Integer> largestValues(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int maxCurr = Integer.MIN_VALUE;
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.remove();
                maxCurr = Math.max(maxCurr, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(maxCurr);
        }
        return ans;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zz = true;
        List<List<Integer>> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            int sizeCurr = queue.size();
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < sizeCurr; i++) {
                TreeNode node = queue.remove();
                curr.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (zz) {
                ans.add(curr);
            } else {
                Collections.reverse(curr);
                ans.add(curr);
            }
            zz = !zz;
        }
        System.out.println(ans);
        return ans;
    }

    public int dfs(TreeNode root, int low, int high, int sum) {
        if (root == null) {
            return sum;
        }
        int left = dfs(root.left, low, high, sum);
        int right = dfs(root.right, low, high, sum);
        if (root.val >= low && root.val <= high) {
            return sum + root.val;
        }
        return sum;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);
        int sum = left + right;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        return sum;
    }

    public int rangeSumBSTIterative(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int ans = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val >= low && node.val <= high) {
                ans += node.val;
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        bfs.rangeSumBSTIterative(root, 7, 15);
    }

}
