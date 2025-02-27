class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int n : prices) {
            minPrice = Math.min(minPrice, n);
            maxProfit = Math.max(maxProfit, n - minPrice);
        }

        return maxProfit;
    }
}