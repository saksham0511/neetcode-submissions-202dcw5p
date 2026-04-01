class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) {
            return nums[0];
        }
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for (int i = 0; i<n-1; i++) {
            nums1[i] = nums[i];
        }
        for (int i = 1; i<n; i++) {
            nums2[i] = nums[i];
        }
        dp1[0] = nums1[0];
        dp1[1] = Math.max(nums1[0], nums1[1]);
        dp2[0] = nums2[0];
        dp2[1] = Math.max(nums2[0], nums2[1]);
        for (int i = 2; i<n; i++) {
            dp1[i] = Math.max(dp1[i-1], nums1[i]+dp1[i-2]);
            dp2[i] = Math.max(dp2[i-1], nums2[i]+dp2[i-2]);
        }
        return Math.max(dp1[n-1], dp2[n-1]);
    }
}
