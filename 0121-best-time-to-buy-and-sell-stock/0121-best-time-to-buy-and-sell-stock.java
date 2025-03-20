class Solution {
    public int maxProfit(int[] prices) {
        int profitMax = 0;
        int priceMin = Integer.MAX_VALUE;

        for (int price : prices) {
            priceMin = Math.min(price, priceMin);
            profitMax = Math.max(price - priceMin, profitMax);
        }

        return profitMax;
    }
}