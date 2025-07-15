class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (isConnected.length == 0 || isConnected[0].length == 0) {
            return 0;
        }
        
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[isConnected.length];
        int provinceCount = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i]) continue;
            queue.offerLast(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                int currCity = queue.pollFirst();
                for (int j = 0; j < isConnected.length; j++) {
                    if (isConnected[currCity][j] == 1 && !visited[j]) {
                        queue.offerLast(j);
                        visited[j] = true;
                    }
                }
            }
            provinceCount++;
        }

        return provinceCount;
    }
}