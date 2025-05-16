class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> stackMin;

    public MinStack() {
        stack = new Stack<>();
        stackMin = new Stack<>();
    }
    
    public void push(int val) {
        stack.add(val);
        int valMin = stackMin.isEmpty() ? val : Math.min(val, stackMin.peek());
        stackMin.add(valMin);
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        stack.pop();
        stackMin.pop();
    }
    
    public int top() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        return stack.peek();
    }
    
    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
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