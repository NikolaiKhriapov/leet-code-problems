class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        List<Integer>[] connections = new ArrayList[n];
        for (int[] edge : edges) {
            List<Integer> curr1 = connections[edge[0]];
            if (curr1 == null) curr1 = new ArrayList<>();
            curr1.add(edge[1]);
            connections[edge[0]] = curr1;
            List<Integer> curr2 = connections[edge[1]];
            if (curr2 == null) curr2 = new ArrayList<>();
            curr2.add(edge[0]);
            connections[edge[1]] = curr2;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == destination) return true;

            for (int neighbor : connections[curr]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return false;
    }
}
