class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int priceMin = Integer.MAX_VALUE;

        for (int price : prices) {
            priceMin = Math.min(price, priceMin);
            maxProfit = Math.max(price - priceMin, maxProfit);
        }        

        return maxProfit;
    }
}