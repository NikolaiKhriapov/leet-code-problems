class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (prices.length == 1) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}

// time  - O(n)
// space - O(1)