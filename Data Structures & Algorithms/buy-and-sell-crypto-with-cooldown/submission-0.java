class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return Math.max(prices[1]-prices[0], 0);
        }
        int[][] dp = new int[n][2]; // 0th index means you bought, 1th index means you sold on ith day
        dp[0][0] = -1*prices[0];
        dp[1][0] = Math.max(-1*prices[1], dp[0][0]);
        dp[1][1] = Math.max(dp[0][0]+prices[1], dp[0][1]);
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-2][1]-prices[i]); // either you buy today or you do not
            dp[i][1] = Math.max(dp[i-1][0]+prices[i], dp[i-1][1]); // either you sell today or not
        }
        return dp[n-1][1];
    }
}
