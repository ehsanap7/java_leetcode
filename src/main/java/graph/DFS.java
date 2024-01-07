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

    private int m;
    private int n;
    private int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean[][] seenNode;

    public int numIslands(char[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        seenNode = new boolean[m][n];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                char land = grid[r][c];
                if (land == '1' && !seenNode[r][c]) {
                    ans++;
                    seenNode[r][c] = true;
                    dfs(grid, r, c);
                }
            }
        }

        return ans;
    }

    public void dfs(char[][] grid, int r, int c) {
        for (int[] direction : directions) {
            int nr = r + direction[0];
            int nc = c + direction[1];
            if (isValid(grid, nr, nc)) {
                seenNode[nr][nc] = true;
                dfs(grid, nr, nc);
            }
        }
    }

    public boolean isValid(char[][] grid, int nr, int nc) {
        return nr > -1 && nr < m && nc > -1 && nc < n && !seenNode[nr][nc] && grid[nr][nc] == '1';
    }

    public int minReorder(int n, int[][] connections) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<String> roads = new HashSet<>();
        Set<Integer> seen = new HashSet<>();

        for (int[] connection : connections) {
            int x = connection[0], y = connection[1];
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }
            graph.get(x).add(y);
            graph.get(y).add(x);
            roads.add(convertToHash(x, y));
        }

        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        seen.add(0);

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            List<Integer> childs = graph.get(curr);
            for (Integer child : childs) {
                if (!seen.contains(child)) {
                    if (roads.contains(String.valueOf(curr) + "," + String.valueOf(child))) {
                        ans++;
                    }
                    stack.push(child);
                    seen.add(child);
                }
            }
        }
        return ans;
    }

    public String convertToHash(int row, int col) {
        return String.valueOf(row) + "," + String.valueOf(col);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < rooms.size(); i++) {
            graph.put(i, rooms.get(i));
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited.add(0);

        while (!stack.isEmpty() && visited.size() < rooms.size()) {
            int node = stack.pop();
            for (int room : graph.get(node)) {
                if (!visited.contains(room)) {
                    visited.add(room);
                    stack.add(room);
                }
            }
        }
        return visited.size() == rooms.size();
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            ans.add(i);
            graph.put(i, new ArrayList<Integer>());
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (List<Integer> edge : edges) {
            Integer x = edge.get(0);
            Integer y = edge.get(1);
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            graph.get(x).add(y);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(edges.get(0).get(0));

        for (Integer key : graph.keySet()) {
            stack.push(key);
            while (!stack.isEmpty()) {
                int curr = stack.pop();
                List<Integer> childs = graph.get(curr);
                if (childs != null) {
                    for (Integer child : childs) {
                        if (ans.contains(child)) {
                            ans.remove(child);
                            stack.push(child);
                        }
                    }
                }
            }
        }
        return ans.stream().toList();
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        System.out.println(dfs.findSmallestSetOfVertices(6,
                List.of(List.of(0, 1), List.of(0, 2),
                        List.of(2, 5), List.of(3, 4),
                        List.of(4, 2))));
    }

}
