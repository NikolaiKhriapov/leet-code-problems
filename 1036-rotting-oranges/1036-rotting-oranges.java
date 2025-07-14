class Solution {
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;
    private static final int FRESH_TO_ROTTEN = 12;
    private static final int[][] NEIGHBORS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        
        int minutes = helper(grid);

        if (isAllRotten(grid)) {
            return minutes;
        }
        return -1;
    }

    private int helper(int[][] grid) {
        boolean isSuccessful = false;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == ROTTEN) {
                    for (int[] neighbor : NEIGHBORS) {
                        if (rotNeighborsTemp(grid, r + neighbor[0], c + neighbor[1])) {
                            isSuccessful = true;
                        }
                    }
                }
            }
        }

        if (isSuccessful) {
            rotNeighborsPerm(grid);
            return 1 + helper(grid);
        }
        return 0;
    }

    private boolean rotNeighborsTemp(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != FRESH) {
            return false;
        }
        grid[row][col] = FRESH_TO_ROTTEN;
        return true;
    }

    private void rotNeighborsPerm(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == FRESH_TO_ROTTEN) {
                    grid[r][c] = ROTTEN;
                }
            }
        }
    }

    private boolean isAllRotten(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == FRESH) {
                    return false;
                }
            }
        }
        return true;
    }
}