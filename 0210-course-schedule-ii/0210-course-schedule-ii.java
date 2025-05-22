class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 1 || prerequisites == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites);
        List<Integer> list = getOrderedListOfCourses(graph, numCourses);
        return reverseListAndReturnArray(list);
    }

    private Map<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int course = 0; course < numCourses; course++) {
            graph.put(course, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        return graph;
    }

    private List<Integer> getOrderedListOfCourses(Map<Integer, List<Integer>> graph, int numCourses) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(graph, course, visited, visiting, list)) {
                return new ArrayList<>();
            }
        }
        return list;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int course, boolean[] visited, boolean[] visiting, List<Integer> list) {
        if (visited[course]) return false;
        if (visiting[course]) return true;
        visiting[course] = true;

        for (int neighbor : graph.getOrDefault(course, new ArrayList<>())) {
            if (hasCycle(graph, neighbor, visited, visiting, list)) {
                return true;
            }
        }

        list.add(course);
        visiting[course] = false;
        visited[course] = true;
        return false;
    }

    private int[] reverseListAndReturnArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(list.size() - 1 - i);
        }
        return array;
    }
}