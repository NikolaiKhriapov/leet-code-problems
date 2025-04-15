class Solution {
    public int maxProfit(int[] prices) {
        int profitTotal = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profitTotal += prices[i] - prices[i - 1];
            }
        }
        
        return profitTotal;
    }
}