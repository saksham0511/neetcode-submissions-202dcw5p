class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == false) {
                    vis[i][j] = true;
                    ans = Math.max(ans, dfs(grid, i, j, vis));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int x, int y, boolean[][] vis) {
        int ans = 1;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        for (int i = 0; i < 4; i++) {
            if (isValid(grid, x+dx[i], y+dy[i], vis)) {
                vis[x+dx[i]][y+dy[i]] = true;
                ans += dfs(grid, x+dx[i], y+dy[i], vis);
            }
        }
        return ans;
    }

    private boolean isValid(int[][] grid, int x, int y, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        return (x >= 0 && x < m && y >= 0 && y < n && vis[x][y] == false && grid[x][y] == 1);
    }
}
