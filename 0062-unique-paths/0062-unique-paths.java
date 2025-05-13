class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int row = 1; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int top = dp[col];
                int left = col > 0 ? dp[col - 1] : 0;
                dp[col] = top + left;
            }
        }
        return dp[n - 1];
    }
}