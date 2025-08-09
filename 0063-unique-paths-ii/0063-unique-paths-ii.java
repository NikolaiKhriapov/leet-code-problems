class Solution {
    private static final int STONE = 1;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (obstacleGrid[0][0] == STONE) {
            return 0;
        }

        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;

        for (int r = 0; r < obstacleGrid.length; r++) {
            for (int c = 0; c < obstacleGrid[0].length; c++) {
                if (r == 0 && c == 0) {
                    continue;
                }
                if (obstacleGrid[r][c] == STONE) {
                    dp[c] = 0;
                } else {
                    int top = r == 0 ? 0 : dp[c];
                    int left = c == 0 ? 0 : dp[c - 1];
                    dp[c] = top + left;
                }
            }
        }
        
        return dp[dp.length - 1];
    }
}

// time  - O(m * n)
// space - O(n)