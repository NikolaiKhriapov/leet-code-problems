class Solution {
    private static final int CONNECTED = 1;

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected.length != isConnected[0].length) {
            throw new IllegalArgumentException("Invalid input");
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[isConnected.length];
        int countProvinces = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i]) {
                continue;
            }
            queue.add(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int j = 0; j < isConnected.length; j++) {
                    if (isConnected[curr][j] == 1 && !visited[j]) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }
            countProvinces++;
        }
        
        return countProvinces;
    }
}