class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        int n = coins.length;
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            for (int j = coin; j <= amount; j++){
                dp[j] = dp[j-coin]+dp[j];
            }
        }
        return dp[amount];
    }
}
