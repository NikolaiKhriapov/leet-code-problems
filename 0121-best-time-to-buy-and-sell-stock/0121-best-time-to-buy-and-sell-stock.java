class Solution {
    public int maxProfit(int[] prices) {
        
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buyPrice) {
                int profitNew = prices[i] - buyPrice;
                if (profitNew > profit) {
                    profit = profitNew;
                }
            }
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }
        }

        return profit;
    }
}
