class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int[] last = new int[]{intervals[0][0], intervals[0][1]};
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (last[0] <= intervals[i][1] && last[1] >= intervals[i][0]) {
                last[0] = Math.min(intervals[i][0], last[0]);
                last[1] = Math.max(intervals[i][1], last[1]);
            } else if (last[1] < intervals[i][0]) {
                ans.add(last);
                last = new int[]{intervals[i][0], intervals[i][1]};
            } 
        }
        ans.add(last);
        return ans.toArray(new int[ans.size()][]);
        
    }
}
