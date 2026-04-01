class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] par = new int[n+1];
        int[] size = new int[n+1];
        for (int i = 0; i<n+1; i++) {
            par[i] = i;
        }
        Arrays.fill(size, 1);
        int[] ans = new int[2];
        for (int i = 0; i<n; i++) {
            if (union(par, size, edges[i][0], edges[i][1])) {
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
            }
        }
        return ans;
    }

    private int find(int[] par, int node) {
        if (node == par[node]) {
            return node;
        }
        par[node] = find(par, par[node]);
        return par[node];
    }

    private boolean union(int[] par, int[] size, int p1, int p2) {
        int parent1 = find(par, p1);
        int parent2 = find(par, p2);
        if (parent1 == parent2) {
            return true;
        }
        if (size[parent1] > size[parent2]) {
            par[parent2] = parent1;
            size[parent1] += size[parent2];
        } else {
            par[parent1] = parent2;
            size[parent2] += size[parent1];
        }
        return false;
    }
}
