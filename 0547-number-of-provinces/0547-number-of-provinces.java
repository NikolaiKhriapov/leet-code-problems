class Solution {
    public int findCircleNum(int[][] isConnected) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int provinces = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                queue.add(i);
                visited.add(i);
                while (!queue.isEmpty()) {
                    int currCity = queue.poll();
                    for (int j = 0; j < isConnected.length; j++) {
                        if (isConnected[currCity][j] == 1 && !visited.contains(j)) {
                            queue.add(j);
                            visited.add(j);
                        }
                    }
                }
                provinces++;
            }
        }
        
        return provinces;
    }
}