class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        int maxSide = 0;

        for (int row = 0; row < rows; row++) {
            dp[row][0] = matrix[row][0] - '0';
            maxSide = Math.max(maxSide, dp[row][0]);
        }
        for (int col = 0; col < cols; col++) {
            dp[0][col] = matrix[0][col] - '0';
            maxSide = Math.max(maxSide, dp[0][col]);
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                dp[row][col] = (matrix[row][col] == '1')
                    ? (1 + getMin(dp[row][col - 1], dp[row - 1][col - 1], dp[row - 1][col]))
                    : 0;
                maxSide = Math.max(maxSide, dp[row][col]);
            }
        }

        return maxSide * maxSide;
    }

    private int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}

// [1,0,1,0,0]
// [1,0,1,1,1]
// [1,1,1,2,2]
// [1,0,0,1,0]
//  2 * 2 = 4