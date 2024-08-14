class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> v1 = map.getOrDefault(edge[0], new ArrayList<>());
            v1.add(edge[1]);
            map.put(edge[0], v1);

            List<Integer> v2 = map.getOrDefault(edge[1], new ArrayList<>());
            v2.add(edge[0]);
            map.put(edge[1], v2);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(source);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;

            for (int option : map.get(curr)) {
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