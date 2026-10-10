class StockSpanner {
    Stack<Stock> stack;
    int day;

    public StockSpanner() {
        stack = new Stack<>();
        day = 0;
    }
    
    public int next(int price) {
        day += 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            stack.pop();
        }
        int ans = day;
        if (!stack.isEmpty()) {
            ans = day - stack.peek().day;
        }
        stack.push(new Stock(price, day));
        return ans;
    }

    class Stock {
        int price;
        int day;
        public Stock(int price, int day) {
            this.price = price;
            this.day = day;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */