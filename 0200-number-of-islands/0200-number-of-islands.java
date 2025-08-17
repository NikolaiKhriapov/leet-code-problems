class Solution {
    private static final char LAND = '1';
    private static final char WATER = '0';
    private static final char TEMP = '.';
    private static final int[][] NEIGHBORS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        return markIslandsAndReturnIslandsCount(grid);
    }

    private int markIslandsAndReturnIslandsCount(char[][] grid) {
        int islandsCount = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == LAND) {
                    markIsland(grid, r, c);
                    islandsCount++;
                }
            }
        }
        return islandsCount;
    }

    private void markIsland(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != LAND) {
            return;
        }
        grid[row][col] = TEMP;
        for (int[] neighbor : NEIGHBORS) {
            markIsland(grid, row + neighbor[0], col + neighbor[1]);
        }
    }
}

// time  - O(n)
// space - O(1)
