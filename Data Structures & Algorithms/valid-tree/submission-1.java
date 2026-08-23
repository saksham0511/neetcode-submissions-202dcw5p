class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean vis[] = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        vis[0] = true;
        boolean ans = dfs(graph, vis, 0, -1);
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                return false;
            }
        }
        return ans;
    }

    public boolean dfs(List<List<Integer>> graph, boolean[] vis, int node, int parent) {
        for (int i : graph.get(node)) {
            if (vis[i] == true && i != parent) {
                return false;
            }
            if (vis[i] == false) {
                vis[i] = true;
                if (dfs(graph, vis, i, node) == false) {
                    return false;
                }
            }
        }
        return true;
    }
}
