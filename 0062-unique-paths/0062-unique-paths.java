class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < m; c++) {
                int top = dp[c];
                int left = c > 0 ? dp[c - 1] : 0;
                dp[c] = top + left;
            }
        }
        return dp[m - 1];
    }
}