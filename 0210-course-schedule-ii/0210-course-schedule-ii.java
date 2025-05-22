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
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(graph, course, visited, visiting, list)) {
                return new ArrayList<>();
            }
        }
        return list;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int course, Set<Integer> visited, Set<Integer> visiting, List<Integer> list) {
        if (visited.contains(course)) return false;
        if (visiting.contains(course)) return true;
        visiting.add(course);

        for (int neighbor : graph.getOrDefault(course, new ArrayList<>())) {
            if (hasCycle(graph, neighbor, visited, visiting, list)) {
                return true;
            }
        }

        list.add(course);
        visiting.remove(course);
        visited.add(course);
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