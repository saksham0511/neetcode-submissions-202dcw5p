class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        PriorityQueue<List<Integer>> q = new PriorityQueue<>((a,b) -> a.get(2) - b.get(2));
        int ans = grid[0][0];
        List<Integer> start = new ArrayList<>();
        start.add(0);
        start.add(0);
        start.add(grid[0][0]);
        q.offer(start);
        while (q.size() > 0) {
            List<Integer> node = q.poll();
            int[] dx = {-1, 0, 0, 1};
            int[] dy = {0, -1, 1, 0};
            ans = Math.max(ans, node.get(2));
            if (node.get(0) == n-1 && node.get(1) == n-1) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = node.get(0) + dx[i];
                int nextY = node.get(1) + dy[i];
                if (valid(nextX, nextY, vis)) {
                    vis[nextX][nextY] = true;
                    List<Integer> nextNode = new ArrayList<>();
                    nextNode.add(nextX);
                    nextNode.add(nextY);
                    nextNode.add(grid[nextX][nextY]);
                    q.offer(nextNode);
                }
            }
        }

        return ans;
    }

    private boolean valid(Integer x, Integer y, boolean[][] vis) {
        int n = vis.length;
        return (x >= 0 && y >= 0 && x < n && y < n && vis[x][y] == false);
    }
}
