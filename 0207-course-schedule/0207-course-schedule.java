class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int course = 0; course < numCourses; course++) {
            graph.put(course, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(graph, course, visited, visiting)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int course, boolean[] visited, boolean[] visiting) {
        if (visited[course]) return false;
        if (visiting[course]) return true;
        visiting[course] = true;

        for (int neighbor : graph.getOrDefault(course, new ArrayList<>())) {
            if (hasCycle(graph, neighbor, visited, visiting)) {
                return true;
            }
        }

        visiting[course] = false;
        visited[course] = true;
        return false;
    }
}