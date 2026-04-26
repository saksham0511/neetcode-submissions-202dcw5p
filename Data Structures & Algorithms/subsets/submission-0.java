class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i <= n; i++) {
            List<Integer> tempAns = new ArrayList();
            recur(nums, i, 0, ans, tempAns);
        }
        return ans;
    }

    private void recur(int[] nums, int count, int ind, List<List<Integer>> ans, List<Integer> tempAns) {
        if (count == 0 && notDuplicate(tempAns, ans)) {
            ans.add(new ArrayList<>(tempAns));
            return;
        }
        int n = nums.length;
        if (ind >= n) {
            return;
        }
        for (int i = ind; i < n; i++) {
            tempAns.add(nums[i]);
            recur(nums, count-1, i+1, ans, tempAns);
            tempAns.remove(tempAns.size()-1);
        }
    }

    private boolean notDuplicate(List<Integer> candidate, List<List<Integer>> ans) {
        int n = ans.size();
        for (int i = 0; i < n; i++) {
            if (compare(ans.get(i), candidate)) {
                return false; // the candidate is identical to existing element
            }
        }
        return true;
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
        return true; // The list are identical
    }
}
