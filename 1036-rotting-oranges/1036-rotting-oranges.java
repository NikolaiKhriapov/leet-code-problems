class Solution {
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;
    private static final int[][] NEIGHBORS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;
        int minuteCount = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == ROTTEN) {
                    queue.add(new int[] {r, c});
                } else if (grid[r][c] == FRESH) {
                    freshCount++;
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isRottenThisMinute = false;
            while (size-- > 0) {
                int[] curr = queue.poll();
                for (int[] neighbor : NEIGHBORS) {
                    int r = curr[0] + neighbor[0];
                    int c = curr[1] + neighbor[1];
                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == FRESH) {
                        queue.add(new int[] {r, c});
                        grid[r][c] = ROTTEN;
                        freshCount--;
                        isRottenThisMinute = true;
                    }
                }
            }
            if (isRottenThisMinute) {
                minuteCount++;
            }
        }

        return freshCount == 0 ? minuteCount : -1;
    }
}