class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] recur = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                vis[i] = true;
                recur[i] = true;
                if (dfs(graph, vis, recur, i) == false) {
                    return false;
                }
                recur[i] = false;
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> graph, boolean[] vis, boolean[] recur, int course) {
        for (int nextCourse : graph.get(course)) {
            if (recur[nextCourse]) {
                return false;
            }
            if (vis[nextCourse] == false) {
                vis[nextCourse] = true;
                recur[nextCourse] = true;
                if (dfs(graph, vis, recur, nextCourse) == false) {
                    return false;
                }
                recur[nextCourse] = false;
            }
        }
        return true;
    }
}
