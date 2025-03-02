class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        List<Integer>[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        visited[source] = true;
        q.add(source);

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == destination) return true;

            for (int option : map[curr]) {
                if (!visited[option]) {
                    visited[option] = true;
                    q.add(option);
                }
            }
        }

        return false;
    }
}
