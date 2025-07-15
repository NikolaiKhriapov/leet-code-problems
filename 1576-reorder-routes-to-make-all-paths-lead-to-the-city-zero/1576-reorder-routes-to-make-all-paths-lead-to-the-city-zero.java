class Solution {
    public int minReorder(int n, int[][] connections) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] connection : connections) {
            graph.get(connection[1]).add(-connection[0]);
            graph.get(connection[0]).add(connection[1]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        visited[0] = true;
        
        int countChanges = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                if (visited[Math.abs(next)]) continue;
                if (next > 0) {
                    countChanges++;
                }
                queue.add(Math.abs(next));
                visited[Math.abs(next)] = true;
            }
        }

        return countChanges;
    }
}