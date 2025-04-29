class Solution {
    private static final char MARK_ISLAND = '1';
    private static final char MARK_WATER = '0';
    private static final char MARK_TEMP = '.';

    public int numIslands(char[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == MARK_ISLAND) {
                    count++;
                    markIsland(grid, r, c);
                }
            }
        }  
        return count;
    }

    private void markIsland(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != MARK_ISLAND) {
            return;
        }
        
        grid[r][c] = MARK_TEMP;

        markIsland(grid, r + 1, c);
        markIsland(grid, r, c + 1);
        markIsland(grid, r - 1, c);
        markIsland(grid, r, c - 1);
    }
}