class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        int max = 0;
        
        for (int row = 0; row < rows; row++) {
            dp[row][0] = matrix[row][0] - '0';
            max = Math.max(max, dp[row][0]);
        }
        for (int col = 0; col < cols; col++) {
            dp[0][col] = matrix[0][col] - '0';
            max = Math.max(max, dp[0][col]);
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                dp[row][col] = (matrix[row][col] == '1')
                    ? (1 + Math.min(dp[row - 1][col], Math.min(dp[row][col - 1], dp[row - 1][col - 1])))
                    : 0;
                max = Math.max(max, dp[row][col]);
            }
        }

        return max * max;
    }
}

// [1,0,1,0,0]
// [1,0,1,1,1]
// [1,1,1,2,2]
// [1,0,0,1,0]
