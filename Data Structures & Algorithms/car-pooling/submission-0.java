class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] freq = new int[1001];
        int n = trips.length;
        for (int i = 0; i < n; i++) {
            freq[trips[i][1]] += trips[i][0];
            freq[trips[i][2]] -= trips[i][0];
        }
        int run = 0;
        for (int i = 0; i < 1001; i++) {
            run += freq[i];
            if (run > capacity) {
                return false;
            }
        }
        return true;
    }
}