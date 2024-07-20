class Solution {
    public int[] finalPrices(int[] prices) {

        Stack<Integer[]> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            while (!stack.isEmpty() && stack.peek()[1] >= p) {
                Integer[] v = stack.pop();
                prices[v[0]] = v[1] - p;
            }
            stack.push(new Integer[] { i, p });
        }
        
        return prices;
    }
}