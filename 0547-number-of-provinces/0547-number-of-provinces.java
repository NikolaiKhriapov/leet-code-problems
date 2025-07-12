class Solution {
    public int findCircleNum(int[][] isConnected) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < isConnected.length; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        int provinces = 0;
        for (var entry : graph.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                queue.add(entry.getKey());
                visited.add(entry.getKey());
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    while (size-- > 0) {
                        int currCity = queue.poll();
                        for (int neighbor : graph.get(currCity)) {
                            if (!visited.contains(neighbor)) {
                                queue.add(neighbor);
                                visited.add(neighbor);
                            }
                        }
                        graph.put(currCity, new ArrayList<>());
                    }
                }
                provinces++;
            }
        }
        
        return provinces;
    }
}