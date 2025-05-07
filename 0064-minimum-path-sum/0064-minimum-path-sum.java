class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            throw new IllegalArgumentException("Invalid input"); //for simplicity
        }

        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 && col == 0) {
                    continue;
                }
                int top = row > 0 ? grid[row - 1][col] : Integer.MAX_VALUE;
                int left = col > 0 ? grid[row][col - 1] : Integer.MAX_VALUE;
                grid[row][col] += Math.min(top, left);
            }
        }
        return grid[rows - 1][cols - 1];
    }
}