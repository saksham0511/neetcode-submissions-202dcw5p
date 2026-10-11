class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                ans += prices[i] - min;
                min = prices[i];
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return ans;
    }
}