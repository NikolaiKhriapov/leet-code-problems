class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[] dp = new int[cols];
        dp[0] = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (obstacleGrid[row][col] == 1) {
                    dp[col] = 0;
                    continue;
                }
                int top = dp[col];
                int left = col > 0 ? dp[col - 1] : 0;
                dp[col] = top + left;
            }
        }

        return dp[cols - 1];
    }
}