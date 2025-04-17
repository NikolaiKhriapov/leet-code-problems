class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') islandCount++;
                markIslandIfNecessary(grid, r, c);
            }
        }
        return islandCount;
    }

    private void markIslandIfNecessary(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        markIslandIfNecessary(grid, r - 1, c);
        markIslandIfNecessary(grid, r + 1, c);
        markIslandIfNecessary(grid, r, c - 1);
        markIslandIfNecessary(grid, r, c + 1);
    }
}