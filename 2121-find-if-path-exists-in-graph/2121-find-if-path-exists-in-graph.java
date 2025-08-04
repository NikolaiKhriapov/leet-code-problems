class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges == null || n < 1) {
            throw new IllegalArgumentException("Invalid input");
        }

        if (source == destination) {
            return true;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : graph.get(curr)) {
                if (neighbor == destination) {
                    return true;
                }
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return false;
    }
}

// time  - O(V + E)
// space - O(V + E)