class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int dist = 1;
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    qx.offer(i);
                    qy.offer(j);
                }
            }
        }
        while (qx.size()!=0) {
            int len = qx.size();
            for (int x = 0; x < len; x++) {
                int i = qx.poll();
                int j = qy.poll();
                for (int y = 0; y < 4; y++) {
                    if (checkValid(i+dx[y], j+dy[y], grid)) {
                        grid[i+dx[y]][j+dy[y]] = dist;
                        qx.offer(i+dx[y]);
                        qy.offer(j+dy[y]);
                    }
                }
            }
            dist += 1;
        }
    }

    private Boolean checkValid(int i, int j, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 2147483647) {
            return true;
        }
        return false;
    }
}
