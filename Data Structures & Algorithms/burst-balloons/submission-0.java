class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> numsList = new ArrayList<>();
        numsList.add(1);
        for (int i = 0; i < n; i++) {
            numsList.add(nums[i]);
        }
        numsList.add(1);
        Integer[][] dp = new Integer[n+2][n+2];
        return dp(dp, numsList, 0, n+1);
    }

    private Integer dp(Integer[][] dp, List<Integer> numsList, int x, int y) {
        if (x >= y-1) {
            return 0;
        }
        if (dp[x][y] != null) {
            return dp[x][y];
        }
        dp[x][y] = 0;
        for (int i = x+1; i < y; i++) {
            dp[x][y] = Math.max(dp[x][y], numsList.get(x)*numsList.get(y)*numsList.get(i) + dp(dp, numsList, x, i) + dp(dp, numsList, i, y));
        }
        return dp[x][y];
    }
}
