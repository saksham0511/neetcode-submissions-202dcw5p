class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int i = 0;
        int j = n-1;
        int ans = 0;
        while (i <= j) {
            if (leftMax > rightMax) {
                ans += Math.max(0, rightMax - height[j]);
                rightMax = Math.max(rightMax, height[j]);
                j-=1;
            } else {
                ans += Math.max(0, leftMax - height[i]);
                leftMax = Math.max(leftMax, height[i]);
                i += 1;
            }
        }
        return ans;
    }
}
