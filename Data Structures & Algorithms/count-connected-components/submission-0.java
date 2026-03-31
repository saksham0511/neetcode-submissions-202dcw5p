class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] vis = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                ans += 1;
                vis[i] = 1;
                dfs(i, graph, vis);
            }
        }
        return ans;
    }

    private void dfs(int node, List<List<Integer>> graph, int[] vis) {
        for (Integer child : graph.get(node)) {
            if (vis[child] == 0) {
                vis[child] = 1;
                dfs(child, graph, vis);
            }
        }
    }
}
