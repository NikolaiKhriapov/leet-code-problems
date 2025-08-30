class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = n;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[(i - j * j)] + 1);
            }
        }
        
        return dp[n];
    }
}

// time  - O(n * logn) (not sure)
// space - O(n)