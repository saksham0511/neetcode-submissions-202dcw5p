class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            if (vis[0][i] == false && board[0][i] == 'O') {
                vis[0][i] = true;
                dfs(board, 0, i, vis);
            }
            if (vis[m-1][i] == false && board[m-1][i] == 'O') {
                vis[m-1][i] = true;
                dfs(board, m-1, i, vis);
            }
        }

        for (int i = 0; i < m; i++) {
            if (vis[i][0] == false && board[i][0] == 'O') {
                vis[i][0] = true;
                dfs(board, i, 0, vis);
            }
            if (vis[i][n-1] == false && board[i][n-1] == 'O') {
                vis[i][n-1] = true;
                dfs(board, i, n-1, vis);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && vis[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y, boolean[][] vis) {
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        for (int i = 0; i < 4; i++) {
            if (isValid(board, x+dx[i], y+dy[i], vis)) {
                vis[x+dx[i]][y+dy[i]] = true;
                dfs(board, x+dx[i], y+dy[i], vis);
            }
        }
    }

    private boolean isValid(char[][] board, int x, int y, boolean[][] vis) {
        int m = board.length;
        int n = board[0].length;
        return (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O' && vis[x][y] == false);
    }
}
