class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (graph.get(ticket.get(0)) == null) {
                graph.put(ticket.get(0), new PriorityQueue<>());
            }
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }

        dfs(graph, "JFK", ans);

        Collections.reverse(ans);
        return ans;
    }

    public void dfs(Map<String, PriorityQueue<String>> graph, String src, List<String> ans) {
        while (graph.get(src) != null && graph.get(src).size() > 0) {
            dfs(graph, graph.get(src).poll(),ans);
        }
        ans.add(src);
    }
}
