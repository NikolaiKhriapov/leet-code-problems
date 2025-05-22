class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int diag;
        int[] dp = new int[matrix[0].length];
        int maxSide = 0;

        for (int col = 0; col < matrix[0].length; col++) {
            dp[col] = matrix[0][col] - '0';
            maxSide = Math.max(maxSide, dp[col]);
        }

        for (int row = 1; row < matrix.length; row++) {
            diag = dp[0];
            dp[0] = matrix[row][0] - '0';
            maxSide = Math.max(maxSide, dp[0]);
            for (int col = 1; col < matrix[0].length; col++) {
                int temp = dp[col];
                dp[col] = (matrix[row][col] == '1')
                    ? (1 + getMin(diag, dp[col], dp[col - 1]))
                    : 0;
                diag = temp;
                maxSide = Math.max(maxSide, dp[col]);
            }
        }

        return maxSide * maxSide;
    }

    private int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}