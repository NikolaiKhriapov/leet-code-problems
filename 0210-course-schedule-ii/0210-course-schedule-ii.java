class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = map.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            map.put(prerequisite[1], list);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        List<Integer> visitedList = new ArrayList<>();
        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(course, map, visited, visiting, visitedList)) {
                return new int[] {};
            }
        }

        int[] result = new int[visitedList.size()];
        for (int i = 0; i < result.length; i++) {
            result[result.length - 1 - i] = visitedList.get(i);
        }

        return result;
    }

    private boolean hasCycle(int course, Map<Integer, List<Integer>> map, boolean[] visited, boolean[] visiting, List<Integer> visitedList) {
        if (visited[course]) return false;
        if (visiting[course]) return true;
        visiting[course] = true;

        for (int el : map.getOrDefault(course, new ArrayList<>())) {
            if (hasCycle(el, map, visited, visiting, visitedList)) {
                return true;
            }
        }

        visiting[course] = false;
        visited[course] = true;
        visitedList.add(course);
        return false;
    }
}