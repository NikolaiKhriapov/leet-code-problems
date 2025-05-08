class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int[] dp = new int[cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 && col == 0) {
                    dp[col] = grid[row][col];
                    continue;
                }
                int top = row > 0 ? dp[col] : Integer.MAX_VALUE;
                int left = col > 0 ? dp[col - 1] : Integer.MAX_VALUE;
                dp[col] = grid[row][col] + Math.min(top, left);
            }
        }
        
        return dp[cols - 1];
    }
}