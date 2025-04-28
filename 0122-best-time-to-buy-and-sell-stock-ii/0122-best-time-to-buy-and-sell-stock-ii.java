class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        if (prices.length <= 1) {
            return 0;
        }

        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;
        
        for (int price : prices) {
            if (price > buyPrice) {
                maxProfit += price - buyPrice;
            }
            buyPrice = price;
        }

        return maxProfit;
    }
}