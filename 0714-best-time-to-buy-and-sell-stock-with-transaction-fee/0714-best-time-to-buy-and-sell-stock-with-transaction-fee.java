class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int cash = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, prices[i] + hold - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}