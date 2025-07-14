class StockSpanner {
    private Stack<Integer> stackValues;
    private Stack<Integer> stackSpans;

    public StockSpanner() {
        stackValues = new Stack<>();
        stackSpans = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (!stackValues.isEmpty() && stackValues.peek() <= price) {
            stackValues.pop();
            span += stackSpans.pop();
        }
        stackValues.add(price);
        stackSpans.add(span);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
