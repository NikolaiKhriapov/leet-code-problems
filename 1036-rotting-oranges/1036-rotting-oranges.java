class Solution {
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;
    private static final int[][] NEIGHBORS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();

        int countFresh = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == FRESH) {
                    countFresh++;
                } else if (grid[r][c] == ROTTEN) {
                    queue.offer(new int[] {r, c});
                }
            }
        }

        int countMinutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isRottenThisMinute = false;
            while (size-- > 0) {
                int[] curr = queue.poll();
                for (int[] neighbor : NEIGHBORS) {
                    int r = curr[0] + neighbor[0];
                    int c = curr[1] + neighbor[1];
                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == FRESH) {
                        grid[r][c] = ROTTEN;
                        queue.add(new int[] {r, c});
                        isRottenThisMinute = true;
                        countFresh--;
                    }
                }
            }
            if (isRottenThisMinute) {
                countMinutes++;
            }
        }
        
        return countFresh == 0 ? countMinutes : -1;
    }
}