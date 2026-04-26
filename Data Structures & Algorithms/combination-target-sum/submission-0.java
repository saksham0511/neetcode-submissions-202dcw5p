class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recur(nums, target, 0, ans, temp);
        return ans;
    }

    private void recur(int[] nums, int target, int ind, List<List<Integer>> ans, List<Integer> temp) {
        if (target == 0 && !isDuplicate(temp, ans)) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (ind >= nums.length || target < 0) {
            return;
        }
        for (int i = ind; i < nums.length; i++) {
            temp.add(nums[i]);
            recur(nums, target-nums[i], i, ans, temp);
            temp.remove(temp.size()-1);
        }
    }

    private boolean isDuplicate(List<Integer> candidate, List<List<Integer>> ans) {
        int n = ans.size();
        for (int i = 0; i < n; i++) {
            if (compare(ans.get(i), candidate)) {
                return true;
            }
        }
        return false;
    }

    private boolean compare(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }
}
