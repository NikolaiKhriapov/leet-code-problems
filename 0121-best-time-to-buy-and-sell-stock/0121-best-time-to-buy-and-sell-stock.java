class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int n = prices.length;
        int[] dp = new int[n];
        int minPrice = prices[0];
        
        dp[0] = 0; // No profit on the first day
        
        for (int i = 1; i < n; i++) {
            // dp[i] is the max profit we can get if we sell on the i-th day
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            // Update the minPrice if we find a new lower price
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        // The maximum profit will be the maximum value in the dp array
        return dp[n - 1];
    }
}
