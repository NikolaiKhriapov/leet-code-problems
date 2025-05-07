class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < m; col++) {
                int top = dp[col];
                int left = col > 0 ? dp[col - 1] : 0;
                dp[col] = top + left;
            }
        }
        return dp[m - 1];
    }
}