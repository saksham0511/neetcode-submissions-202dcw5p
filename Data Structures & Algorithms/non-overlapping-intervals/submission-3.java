class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        int n = intervals.length;
        int[] last = new int[]{intervals[0][0], intervals[0][1]};
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < last[1] && intervals[i][1] > last[0]) {
                count += 1;
                continue;
            }
            last[0] = intervals[i][0];
            last[1] = intervals[i][1];
        }
        return count;
    }
}
