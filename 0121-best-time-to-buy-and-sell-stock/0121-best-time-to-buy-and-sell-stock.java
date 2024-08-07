class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int buyPrice = prices[0];
        
        for (int i = 1, l = prices.length; i < l; i++) {
            int curr = prices[i];
            int profit = curr - buyPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            } else if (curr < buyPrice) {
                buyPrice = curr;
            }
        }

        return maxProfit;
    }
}