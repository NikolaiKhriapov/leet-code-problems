class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        if ((obstacleGrid.length == 1 || obstacleGrid[0].length == 1) && obstacleGrid[0][0] == 1) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        int[] dp = new int[cols];
        dp[0] = 1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (obstacleGrid[r][c] == 1) {
                    dp[c] = 0;
                    continue;
                }
                int prev = c > 0 ? dp[c - 1] : 0;
                dp[c] = dp[c] + prev;
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[cols - 1];
    }
}