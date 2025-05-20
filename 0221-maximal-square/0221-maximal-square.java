class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] dp = new int[cols];
        int max = 0;
        int diag = 0;
        
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
                    ? (1 + Math.min(diag, Math.min(dp[col], dp[col - 1])))
                    : 0;
                diag = temp;
                max = Math.max(max, dp[col]);
            }
        }

        return max * max;
    }
}

// [1,0,1,0,0]
// [1,0,1,1,1]
// [1,1,1,2,2]
// [1,0,0,1,0]
