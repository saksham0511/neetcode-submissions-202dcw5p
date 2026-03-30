class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = 0;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (piles[i] > high) {
                high = piles[i];
            }
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int hours = 0;
            for (int i = 0; i < n; i++) {
                hours += (int) Math.ceil((double) piles[i] / mid);
            }
            if (hours > h) {
                low = mid + 1;
                continue;
            } else {
                high = mid - 1;
            }
            if (ans == -1 || mid < ans) {
                ans = mid;
            }
        }
        return ans;
    }
}
