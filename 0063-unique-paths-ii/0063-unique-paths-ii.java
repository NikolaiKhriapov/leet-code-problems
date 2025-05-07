class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[] dp = new int[cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (obstacleGrid[row][col] == 1) {
                    dp[col] = 0;
                    continue;
                } else {
                    if (row == 0 && col == 0) {
                        dp[col] = 1;
                        continue;
                    }
                    int top = dp[col];
                    int left = col > 0 ? dp[col - 1] : 0;
                    dp[col] = top + left;
                }
            }
        }
        return dp[cols - 1];
    }
}
