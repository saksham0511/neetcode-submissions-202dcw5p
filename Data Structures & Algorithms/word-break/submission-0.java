class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        Integer[] dp = new Integer[n];
        return dp(s, dp, 0, dict)==1;
    }


    private Integer dp(String s, Integer[] dp, Integer i, Set<String> dict) {
        int n = s.length();
        if (i >= n) {
            return 1;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        dp[i] = -1;
        for (int x = i; x <= n; x++) {
            if (dict.contains(s.substring(i,x)) && dp(s, dp, x, dict)==1) {
                dp[i] = 1;
                break;
            }
        }
        return dp[i];
    }
}
