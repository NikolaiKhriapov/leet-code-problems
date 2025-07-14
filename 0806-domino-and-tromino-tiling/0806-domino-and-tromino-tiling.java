class Solution {
    private static final long MODULO = 1_000_000_007;

    public int numTilings(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        long preSum = 0;
        for (int i = 3; i <= n; i++) {
            preSum += 2 * dp[i - 3];
            dp[i] = (dp[i - 1] + dp[i - 2] + preSum) % MODULO;
        }
        
        return (int) dp[n];
    }
}