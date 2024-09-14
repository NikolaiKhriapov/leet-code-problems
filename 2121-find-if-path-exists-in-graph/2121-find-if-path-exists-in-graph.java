class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }

        List<Integer>[] connections = new ArrayList[n];
        for (int i = 0; i < connections.length; i++) {
            connections[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            connections[edge[0]].add(edge[1]);
            connections[edge[1]].add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int option : connections[curr]) {
                if (option == destination) {
                    return true;
                } else {
                    if (!visited[option]) {
                        queue.add(option);
                        visited[option] = true;
                    }
                }
            }
        }
        
        return false;
    }
}