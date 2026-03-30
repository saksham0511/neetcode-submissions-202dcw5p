class Solution {
    public int orangesRotting(int[][] grid) {
        int freshFruits = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        int mins = 0;

        for (int i = 0; i<m ; i++) {
            for (int j = 0; j<n ; j++) {
                if (grid[i][j] == 1) {
                    freshFruits += 1;
                }
                if (grid[i][j] == 2) {
                    qx.offer(i);
                    qy.offer(j);
                }
            }
        }

        if (freshFruits == 0) {
            return 0;
        }

        while (qx.size() > 0) {
            int len = qx.size();
            for (int i = 0; i < len; i++) {
                int x = qx.poll();
                int y = qy.poll();
                for (int j = 0; j < 4; j++) {
                    if (checkValid(grid, x+dx[j],y+dy[j])) {
                        grid[x+dx[j]][y+dy[j]] = 2;
                        freshFruits -= 1;
                        qx.offer(x+dx[j]);
                        qy.offer(y+dy[j]);
                    }
                }
            }
            mins += 1;
            if (freshFruits == 0) {
                break;
            }
        }

        if (freshFruits == 0) {
            return mins;
        }
        return -1;
    }

    private Boolean checkValid(int[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
            return true;
        }
        return false;
    }
}
