class MinStack {
    private Stack<Integer> stackValues;
    private Stack<Integer> stackMins;

    public MinStack() {
        stackValues = new Stack<>();
        stackMins = new Stack<>();
    }
    
    public void push(int val) {
        stackValues.push(val);
        int nextMin = stackMins.isEmpty() ? val : Math.min(val, stackMins.peek());
        stackMins.push(nextMin);
    }
    
    public void pop() {
        stackValues.pop();
        stackMins.pop();
    }
    
    public int top() {
        return stackValues.peek();
    }
    
    public int getMin() {
        return stackMins.peek();
    }
}

// time  - O(1)
// space - O(n)