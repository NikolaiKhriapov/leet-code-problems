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
        Set<Integer> visited = new HashSet<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == destination) return true;

            List<Integer> neighbors = connections[curr];
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return false;
    }
}
