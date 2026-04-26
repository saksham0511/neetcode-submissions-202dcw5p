class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] vis = new boolean[n];
        recur(nums, n, ans, temp, vis);
        return ans;
    }

    private void recur(int[] nums, int count, List<List<Integer>> ans, List<Integer> temp, boolean[] vis) {
        if (count == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] == false) {
                vis[i] = true;
                temp.add(nums[i]);
                recur(nums, count-1, ans, temp, vis);
                temp.remove(temp.size()-1);
                vis[i] = false;
            }
        }
    }
}
