class Solution {
    private int ans = -1;
    private int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int current = recur(matrix,i,j);
                if (current > ans) ans = current;
            }
        }
        return ans;
    }

    public int recur(int[][] matrix, int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int maxVal = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (valid(matrix, nx, ny) && matrix[nx][ny] > matrix[x][y]) {
                maxVal = Math.max(maxVal, recur(matrix, nx, ny));
            }
        }
        dp[x][y] = maxVal + 1;
        return dp[x][y];
    }

    private boolean valid(int[][] matrix, int x, int y) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (x >= 0 && x < m && y >= 0 && y < n) {
            return true;
        }
        return false;
    }
}