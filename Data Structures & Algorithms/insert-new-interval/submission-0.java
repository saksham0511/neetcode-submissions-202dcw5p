class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                continue;
            } else if (!flag && intervals[i][0] > newInterval[1]) {
                ans.add(newInterval);
                flag = true;
            }
            ans.add(intervals[i]);
        }
        if (flag == false) {
            ans.add(newInterval);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
