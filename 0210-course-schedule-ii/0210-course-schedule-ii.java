class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || (prerequisites.length > 0 && prerequisites[0].length != 2)) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int course = 0; course < numCourses; course++) {
            graph.put(course, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        List<Integer> list = new ArrayList<>();

        for (int course = 0; course < numCourses; course++) {
            if (!canTakeCourse(graph, course, visited, visiting, list)) {
                return new int[0];
            }
        }

        return listToArray(list);
    }

    private boolean canTakeCourse(Map<Integer, List<Integer>> graph, int course, boolean[] visited, boolean[] visiting, List<Integer> list) {
        if (visited[course]) return true;
        if (visiting[course]) return false;
        visiting[course] = true;

        for (int prerequisite : graph.get(course)) {
            if (!canTakeCourse(graph, prerequisite, visited, visiting, list)) {
                return false;
            }
        }

        list.add(course);
        visiting[course] = false;
        visited[course] = true;
        return true;
    }

    private int[] listToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

// time  - O(n + p)
// space - O(n + p)