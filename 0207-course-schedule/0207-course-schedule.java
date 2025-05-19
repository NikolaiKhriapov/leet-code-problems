class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (prerequisites.length == 0) {
            return true;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (!graph.containsKey(prerequisite[0])) {
                graph.put(prerequisite[0], new ArrayList<>());
            }
            graph.get(prerequisite[0]).add(prerequisite[1]);
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

        for (int el : graph.getOrDefault(course, new ArrayList<>())) {
            if (hasCycle(graph, el, visited, visiting)) {
                return true;
            }
        }

        visiting.remove(course);
        visited.add(course);
        return false;
    }
}