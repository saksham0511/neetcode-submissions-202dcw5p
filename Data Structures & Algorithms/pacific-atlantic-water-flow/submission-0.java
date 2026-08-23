class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] vis1 = new boolean[m][n];
        boolean[][] vis2 = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 || j==0) {
                    vis1[i][j] = true;
                    dfs(heights, vis1, i, j);
                }
                if (i == m-1 || j == n-1) {
                    vis2[i][j] = true;
                    dfs(heights, vis2, i, j);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis1[i][j] == true && vis2[i][j] == true) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(i);
                    curr.add(j);
                    ans.add(curr);
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] heights, boolean[][] vis, int x, int y) {
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int m = heights.length;
        int n = heights[0].length;
        for (int i = 0; i < 4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];
            if (newx >= 0 && newx < m && newy >= 0 && newy < n && !vis[newx][newy] && heights[x][y] <= heights[newx][newy]) {
                vis[newx][newy] = true;
                dfs(heights, vis, newx, newy);
            }
        }
    }
}
