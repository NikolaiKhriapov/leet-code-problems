class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int r = 1; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int top = dp[c];
                int left = c == 0 ? 0 : dp[c - 1];
                dp[c] = top + left;
            }
        }

        return dp[n - 1];
    }
}

// time  - O(m * n)
// space - O(n)