class FreqStack {
    int max;
    Map<Integer, Integer> valToCount;
    Map<Integer, Stack<Integer>> countToStack;

    public FreqStack() {
        max = 0;
        valToCount = new HashMap<>();
        countToStack = new HashMap<>();
    }
    
    public void push(int val) {
        int count = valToCount.getOrDefault(val, 0) + 1;
        max = Math.max(max, count);
        valToCount.put(val, count);
        if (countToStack.get(count) == null) {
            countToStack.put(count, new Stack<>());
        }
        Stack<Integer> stack = countToStack.get(count);
        stack.push(val);
    }
    
    public int pop() {
        Stack<Integer> stack = countToStack.get(max);
        int ans = stack.pop();
        valToCount.put(ans, valToCount.get(ans)-1);
        if (stack.isEmpty()) {
            countToStack.put(max, null);
            max -= 1;
        }
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */