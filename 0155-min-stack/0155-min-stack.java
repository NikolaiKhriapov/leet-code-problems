class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> stackMin;

    public MinStack() {
        stack = new Stack<>();
        stackMin = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        int minVal = stackMin.isEmpty() ? val : Math.min(val, stackMin.peek());
        stackMin.push(minVal);
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        stack.pop();
        stackMin.pop();
    }
    
    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return stack.peek();
    }
    
    public int getMin() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
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