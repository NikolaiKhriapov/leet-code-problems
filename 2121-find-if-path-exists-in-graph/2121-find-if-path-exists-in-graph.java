class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        List<Integer>[] neighbors = new ArrayList[n + 1];
        for (int[] edge : edges) {
            neighbors[edge[0]] = new ArrayList<>();
            neighbors[edge[1]] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            neighbors[edge[0]].add(edge[1]);
            neighbors[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> unvisited = new LinkedList<>();
        unvisited.add(source);
        visited[source] = true;

        while (!unvisited.isEmpty()) {
            int curr = unvisited.poll();
            for (int neighbor : neighbors[curr]) {
                if (neighbor == destination) {
                    return true;
                } else if (!visited[neighbor]) {
                    unvisited.add(neighbor);
                    visited[neighbor] = true;
                }
            }

        }
        
        return false;
    }
}