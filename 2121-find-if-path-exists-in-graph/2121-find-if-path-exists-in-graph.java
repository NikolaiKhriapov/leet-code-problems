class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        List<Integer>[] arr = new ArrayList[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            arr[edge[0]].add(edge[1]);
            arr[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> unvisited = new LinkedList<>();
        unvisited.add(source);
        visited[source] = true;

        while (!unvisited.isEmpty()) {
            int curr = unvisited.poll();
            for (int option : arr[curr]) {
                if (option == destination) return true;
                if (!visited[option]) {
                    unvisited.add(option);
                    visited[option] = true;
                }
            }
        }

        return false;
    }
}
