class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top >= 0 && prices[stack[top]] >= prices[i]) {
                prices[stack[top]] = prices[stack[top]] - prices[i];
                top--;
            }
            stack[++top] = i;
        }
        return prices;
    }
}
