class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected[0].length != isConnected.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i]) {
                continue;
            }
            queue.add(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                int city = queue.poll();
                for (int j = 0; j < isConnected.length; j++) {
                    if (isConnected[city][j] == 1 && !visited[j]) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }
            provinces++;
        }
        
        return provinces;
    }
}