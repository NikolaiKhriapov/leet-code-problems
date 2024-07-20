class Solution {
    public int[] finalPrices(int[] prices) {

        Stack<Integer> indices = new Stack<>();
        Stack<Integer> values = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            while (!values.isEmpty() && values.peek() >= p) {
                prices[indices.pop()] = values.pop() - p;
            }
            indices.push(i);
            values.push(p);
        }
        
        return prices;
    }
}