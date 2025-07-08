class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k <= 0 || prices == null || prices.length <= 1) {
            return 0;
        }

        if (k >= prices.length / 2) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }
}

// [3,2,6,5,0,3]

// [0,0,0,0,0,0]
// [0,0,4,4,4,4]
// [0,0,4,4,4,7]

// maxDiff = 4