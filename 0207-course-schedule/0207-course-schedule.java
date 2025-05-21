class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (numCourses == 0 || prerequisites.length == 0) {
            return true;
        }
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int course = 0; course < numCourses; course++) {
            graph.put(course, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(graph, course, visited, visiting)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int course, Set<Integer> visited, Set<Integer> visiting) {
        if (visited.contains(course)) return false;
        if (visiting.contains(course)) return true;
        visiting.add(course);

        for (int neighbor : graph.getOrDefault(course, new ArrayList<>())) {
            if (hasCycle(graph, neighbor, visited, visiting)) {
                return true;
            }
        }

        visiting.remove(course);
        visited.add(course);
        return false;
    }
}