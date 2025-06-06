class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> stackMin;

    public MinStack() {
        stack = new Stack<>();
        stackMin = new Stack<>();
    }
    
    public void push(int val) {
        stack.add(val);
        int minVal = stackMin.isEmpty() ? val : Math.min(val, stackMin.peek());
        stackMin.add(minVal);
    }
    
    public void pop() {
        stack.pop();
        stackMin.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return stackMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */