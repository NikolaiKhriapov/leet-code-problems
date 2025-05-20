class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = n;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}

// [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12]
// [ 0,12,12,12,12,12,12,12,12,12,12,12,12]
// [ 0, 1, 2, 3, 1, 2, 3, 4, 2, 1, 2, 3, 3]