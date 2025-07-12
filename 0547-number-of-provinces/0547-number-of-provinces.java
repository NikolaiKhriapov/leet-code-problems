class Solution {
    public int findCircleNum(int[][] isConnected) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int currCity = queue.poll();
                    for (int j = 0; j < isConnected.length; j++) {
                        if (isConnected[currCity][j] == 1 && !visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
                provinces++;
            }
        }
        
        return provinces;
    }
}