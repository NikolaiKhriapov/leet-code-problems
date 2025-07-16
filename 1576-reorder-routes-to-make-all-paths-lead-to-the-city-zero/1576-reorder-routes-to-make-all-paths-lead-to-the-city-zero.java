class Solution {
    public int minReorder(int n, int[][] connections) {
        if (n <= 0 || connections == null || connections.length == 0 || connections[0].length != 2) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] connection : connections) {
            graph.get(connection[0]).add(-connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        visited[0] = true;

        int countChanges = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : graph.get(curr)) {
                if (!visited[Math.abs(neighbor)]) {
                    if (neighbor < 0) {
                        countChanges++;
                        neighbor = -neighbor;
                    }
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return countChanges;
    }
}