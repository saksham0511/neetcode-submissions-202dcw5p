class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            while (stack.size() > 0 && stack.peek() > 0 && asteroids[i] + stack.peek() < 0) {
                stack.pop();
            }
            if (stack.size() > 0 && asteroids[i] < 0 && asteroids[i] + stack.peek() == 0) {
                stack.pop();
                continue;
            }
            if (stack.size() > 0 && asteroids[i] < 0 && asteroids[i] + stack.peek() > 0) {
                continue;
            }
            stack.push(asteroids[i]);
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}