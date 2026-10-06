class Solution { 
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Flight>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            graph.get(flights[i][0]).add(new Flight(flights[i][1], flights[i][2]));
        }      
        Integer[][] dp = new Integer[n][k+1];
        return helper(graph, dp, src, dst, k) != Integer.MAX_VALUE ? dp[src][k] : -1;
    }

    private int helper(List<List<Flight>> graph, Integer[][] dp, int src, int dst, int k) {
        if (src == dst) {
            return 0;
        }
        if (k == -1) {
            return Integer.MAX_VALUE;
        }
        if (dp[src][k] != null) {
            return dp[src][k];
        }
        dp[src][k] = Integer.MAX_VALUE;
        for (Flight flight : graph.get(src)) {
            if (helper(graph, dp, flight.dst, dst, k-1) != Integer.MAX_VALUE) {
                dp[src][k] = Math.min(dp[src][k], flight.price + helper(graph, dp, flight.dst, dst, k-1));
            }
        }
        return dp[src][k];
    }

    class Flight {
        int dst;
        int price;
        public Flight(int dst, int price) {
            this.dst = dst;
            this.price = price;
        }
    }
}