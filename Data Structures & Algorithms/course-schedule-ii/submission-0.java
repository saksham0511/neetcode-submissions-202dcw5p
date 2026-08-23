class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]] += 1;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int vis = 0;
        int x = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                vis += 1;
            }
        }
        while (q.size() > 0) {
            int node = q.poll();
            ans[x] = node;
            x += 1;
            for (int next : graph.get(node)) {
                indegree[next] -= 1;
                if (indegree[next] == 0) {
                    q.offer(next);
                    vis += 1;
                }
            }
        }

        if (vis < numCourses) {
            return new int[0];
        }
        return ans;
    }
}
