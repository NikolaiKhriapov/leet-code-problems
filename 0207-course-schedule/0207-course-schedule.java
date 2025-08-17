class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null || (prerequisites.length > 0 && prerequisites[0].length != 2)) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!canBeTaken(graph, i, visited, visiting)) {
                return false;
            }
        }

        return true;
    }

    private boolean canBeTaken(Map<Integer, List<Integer>> graph, int course, boolean[] visited, boolean[] visiting) {
        if (visited[course]) return true;
        if (visiting[course]) return false;
        visiting[course] = true;

        for (int neighbor : graph.get(course)) {
            if (!canBeTaken(graph, neighbor, visited, visiting)) {
                return false;
            }
        }

        visiting[course] = false;
        visited[course] = true;
        return true;
    }
}

// time  - O(n)
// space - O(n)
