class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        Map<Integer, List<Integer>> connections = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> curr1 = connections.getOrDefault(edge[0], new ArrayList<>());
            curr1.add(edge[1]);
            connections.put(edge[0], curr1);
            List<Integer> curr2 = connections.getOrDefault(edge[1], new ArrayList<>());
            curr2.add(edge[0]);
            connections.put(edge[1], curr2);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == destination) return true;

            List<Integer> neighbors = connections.get(curr);
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
