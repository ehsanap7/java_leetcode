package graph;

import java.util.*;

public class DFS {

    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> seen = new HashSet<>();

    public int findCircleNum(int[][] isConnected) {
        int ans = 0;


        for (int i = 0; i < isConnected.length; i++) {
            if (!graph.containsKey(i)) {
                graph.put(i, new ArrayList<>());
            }
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }


        for (Integer key : graph.keySet()) {
            if (!seen.contains(key)) {
                ans += 1;
                seen.add(key);
                dfs(key);
            }
        }

        return ans;
    }

    public void dfs(int node) {
        List<Integer> nodeList = graph.get(node);
        for (Integer i : nodeList) {
            if (!seen.contains(i)) {
                seen.add(i);
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        System.out.println(dfs.findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
    }

}
