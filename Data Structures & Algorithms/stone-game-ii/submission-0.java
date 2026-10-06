class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        Integer[][][] dp = new Integer[n+1][n+1][2];
        return helper(piles, dp, 0, 1)[0];
    }

    private Integer[] helper(int[] piles, Integer[][][] dp, int x, int m) {
        int n = piles.length;
        if (x == n) {
            return new Integer[]{0, 0};
        }
        int sum = 0;
        for (int i = x; i < n; i++) {
            sum += piles[i];
        }
        if (dp[x][m][0] != null) {
            return dp[x][m];
        }
        dp[x][m] = new Integer[]{0, 0};
        int pre = 0;
        for (int i = x; i < Math.min(n, x+2*m); i++) {
            pre += piles[i];
            if (pre + helper(piles, dp, i+1, Math.max(m, i-x+1))[1] > dp[x][m][0]) {
                dp[x][m][0] = pre + helper(piles, dp, i+1, Math.max(m, i-x+1))[1];
                dp[x][m][1] = sum - dp[x][m][0];
            }
        }
        return dp[x][m];
    }

}