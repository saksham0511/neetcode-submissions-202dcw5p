class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][][] dp = new Integer[n][n][2];
        if (dp(piles, 0, n-1, dp)[0] > dp(piles, 0, n-1, dp)[1]) {
            return true;
        }
        return false;
    }

    private Integer[] dp(int[] piles, int x, int y, Integer[][][] dp) {
        if (x == y) {
            Integer[] ans = {piles[x], 0};
            return ans;
        }
        if (dp[x][y][0] != null) {
            return dp[x][y];
        }
        int sum = 0;
        for (int i = x; i <= y; i++) {
            sum += piles[i];
        }
        dp[x][y][0] = Math.max(piles[x] + dp(piles, x+1, y, dp)[1], piles[y] + dp(piles, x, y-1, dp)[1]);
        dp[x][y][1] = sum - dp[x][y][0];
        return dp[x][y];
    }
}