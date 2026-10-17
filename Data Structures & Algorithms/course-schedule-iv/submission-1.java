class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Set<Integer>> prereqs = new ArrayList<>();
        boolean[] vis = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
            prereqs.add(new HashSet<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == false) {
                vis[i] = true;
                dfs(graph, prereqs, i, vis);
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            ans.add(prereqs.get(queries[i][0]).contains(queries[i][1]));
        }
        return ans;
    }

    private void dfs(List<List<Integer>> graph, List<Set<Integer>> prereqs, Integer node, boolean[] vis) {
        for (Integer next : graph.get(node)) {
            if (vis[next] == false) {
                vis[next] = true;
                dfs(graph,prereqs,next,vis);
            }
            prereqs.get(node).addAll(prereqs.get(next));
            prereqs.get(node).add(next);
        }
    }
}