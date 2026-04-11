class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int ans = heights[0];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int h = heights[stack.pop()];
                int initial = stack.isEmpty() ? -1 : stack.peek();
                ans = Math.max(ans, (i-initial-1)*h);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int initial = stack.isEmpty() ? -1 : stack.peek();
            ans = Math.max(ans, (n-initial-1)*h);
        }
        return ans;
    }
}
