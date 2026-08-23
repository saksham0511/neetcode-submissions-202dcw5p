class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<List<Integer>>> graph = new ArrayList<>();
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < times.length; i++) {
            List<Integer> node = new ArrayList<>();
            node.add(times[i][1]-1);
            node.add(times[i][2]);
            graph.get(times[i][0]-1).add(node);
        }
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> a.get(1) - b.get(1));
        boolean[] vis = new boolean[n];
        vis[k-1] = true;
        dist[k-1] = 0;
        int ans = 0;
        for (List<Integer> node : graph.get(k-1)) {
            pq.offer(node);
        }
        while (pq.size() > 0) {
            List<Integer> node = pq.poll();
            if (vis[node.get(0)]) {
                continue;
            }
            dist[node.get(0)] = node.get(1);
            vis[node.get(0)] = true;
            ans = Math.max(ans, node.get(1));
            for (List<Integer> next : graph.get(node.get(0))) {
                if (vis[next.get(0)] == false) {
                    next.set(1, next.get(1) + node.get(1));
                    pq.offer(next);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                return -1;
            }
        }
        return ans;
    }
}
