class Solution {
    private static final int MODULO = 1_000_000_007;

    public int numTilings(int n) {

        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            // dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MODULO;
            dp[i] = dp[i - 1] + dp[i - 2];
            for (int j = i - 3; j >= 0; j--) {
                dp[i] += 2 * dp[j];
            }
            dp[i] = dp[i] % MODULO;
        }
        
        return (int) dp[n];
    }
}

// dp[n - 2] + dp[n - 1] = dp[n] - dp[2] + dp[n] - dp[1] = 2*dp[n] - dp[2] - dp[1]