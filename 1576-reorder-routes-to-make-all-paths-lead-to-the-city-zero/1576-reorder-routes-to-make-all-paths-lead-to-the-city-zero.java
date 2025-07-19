class Solution {
    public int minReorder(int n, int[][] connections) {
        if (n <= 1 || connections == null || connections.length == 0 || connections[0].length != 2) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] connection : connections) {
            map.get(connection[0]).add(-connection[1]);
            map.get(connection[1]).add(connection[0]);
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        visited[0] = true;

        int changeCount = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : map.get(curr)) {
                if (visited[Math.abs(next)]) {
                    continue;
                }
                if (next < 0) {
                    next = -next;
                    changeCount++;
                }
                queue.add(next);
                visited[next] = true;
            }
        }

        return changeCount;
    }
}
