class Solution {
    public void sortColors(int[] nums) {
        int z = 0;
        int o = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                z += 1;
            }
            if (nums[i] == 1) {
                o += 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (z > 0) {
                nums[i] = 0;
                z -= 1;
            } else if (o > 0) {
                nums[i] = 1;
                o -= 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}