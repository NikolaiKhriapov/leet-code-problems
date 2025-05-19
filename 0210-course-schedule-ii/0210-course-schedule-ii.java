class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || numCourses < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (!graph.containsKey(prerequisite[1])) {
                graph.put(prerequisite[1], new ArrayList<>());
            }
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        List<Integer> coursesList = new LinkedList<>();

        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(graph, course, visited, visiting, coursesList)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < coursesList.size(); i++) {
            result[i] = coursesList.get(i);
        }

        return result;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int course, Set<Integer> visited, Set<Integer> visiting, List<Integer> coursesList) {
        if (visited.contains(course)) return false;
        if (visiting.contains(course)) return true;
        visiting.add(course);

        for (int el : graph.getOrDefault(course, new ArrayList<>())) {
            if (hasCycle(graph, el, visited, visiting, coursesList)) {
                return true;
            }
        }

        visiting.remove(course);
        visited.add(course);
        coursesList.add(0, course);
        return false;
    }
}