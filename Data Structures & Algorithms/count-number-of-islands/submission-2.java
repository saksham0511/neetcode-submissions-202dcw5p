class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    vis[i][j] = 1;
                    dfs(vis, grid, i, j, m, n);
                    ans += 1;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] vis, char[][] grid, int i, int j, int m, int n) {
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        for (int x = 0; x < 4; x++) {
            if (i+dx[x] >= 0 && i+dx[x]<m && j+dy[x] >= 0 && j+dy[x] < n && vis[i+dx[x]][j+dy[x]] == 0 && grid[i+dx[x]][j+dy[x]] == '1') {
                vis[i+dx[x]][j+dy[x]] = 1;
                dfs(vis, grid, i+dx[x], j+dy[x], m, n);
            }
        }
    }
}
