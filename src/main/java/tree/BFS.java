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

    public int getMinimumDifference(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        getSortedBSTIterative(root, vals);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < vals.size(); i++) {
            ans = Math.min(ans, vals.get(i) - vals.get(i - 1));
        }
        return ans;
    }

    public void getSortedBST(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return;
        }
        getSortedBST(root.left, vals);
        vals.add(root.val);
        getSortedBST(root.right, vals);
    }

    public void getSortedBSTIterative(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr = root;
        while (!stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                vals.add(node.val);
                curr = curr.right;
            }
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);
        if (root.left != null && root.val < root.left.val) {
            return false;
        }
        if (root.right != null && root.val > root.right.val) {
            return false;
        }
        return left && right;
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

    public int closestValue(TreeNode root, double target) {
        return dfs(root, target, Double.MAX_VALUE, 0);
    }

    public int dfs(TreeNode root, double target, double minSoFar, int minSoFarIndex) {
        if (root == null) {
            return 0;
        }

        dfs(root.left, target, minSoFar, minSoFarIndex);
        dfs(root.right, target, minSoFar, minSoFarIndex);
        if (Math.abs(root.val - target) < minSoFar) {
            minSoFar = Math.abs(root.val - target);
            minSoFarIndex = root.val;
        }
        return minSoFarIndex;
    }

    public int closestValue2(TreeNode root, double target) {
        int ans = 0;
        double diff = Double.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                double curr = Math.abs(node.val - target);
                if (curr < diff || curr == diff && node.val < ans) {
                    ans = node.val;
                    diff = curr;
                }
                stack.push(node.val < target ? node.right : node.left);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(bfs.closestValue2(root, 3.714286));
    }

}
