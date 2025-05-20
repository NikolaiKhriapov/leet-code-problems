class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] dp = new int[cols];
        int diag = 0; //temp
        int max = 0;

        for (int col = 0; col < cols; col++) {
            dp[col] = matrix[0][col] - '0';
            max = Math.max(max, dp[col]);
        }
        
        for (int row = 1; row < rows; row++) {
            diag = dp[0];
            dp[0] = matrix[row][0] - '0';
            max = Math.max(max, dp[0]);
            for (int col = 1; col < cols; col++) {
                int temp = dp[col];
                dp[col] = (matrix[row][col] == '1')
                    ? (1 + Math.min(dp[col - 1], Math.min(diag, dp[col])))
                    : 0;
                diag = temp;
                max = Math.max(max, dp[col]);
            }
        }

        return max * max;
    }
}