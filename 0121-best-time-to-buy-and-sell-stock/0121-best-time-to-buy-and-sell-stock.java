class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int buyPrice = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - buyPrice;
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}