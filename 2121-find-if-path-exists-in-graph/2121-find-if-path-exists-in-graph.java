class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (map.containsKey(edge[0])) map.get(edge[0]).add(edge[1]);
            else map.put(edge[0], new ArrayList<>(List.of(edge[1])));
            
            if (map.containsKey(edge[1])) map.get(edge[1]).add(edge[0]);
            else map.put(edge[1], new ArrayList<>(List.of(edge[0])));
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        visited[source] = true;
        q.add(source);

        while (!q.isEmpty()) {
            int node = q.poll();

            if (node == destination) return true;

            for (int neighbor : map.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        return false;
    }
}
