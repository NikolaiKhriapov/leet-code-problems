class Solution {
    public int minPathSum(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[] dp = new int[cols];
        dp[0] = grid[0][0];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 && c == 0) continue;
                int top = r > 0 ? dp[c] : Integer.MAX_VALUE;
                int left = c > 0 ? dp[c - 1] : Integer.MAX_VALUE;
                dp[c] = grid[r][c] + Math.min(top, left);
            }
        }

        return dp[cols - 1];
    }
}