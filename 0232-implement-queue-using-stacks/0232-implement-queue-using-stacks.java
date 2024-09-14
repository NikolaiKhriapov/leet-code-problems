class MyQueue {

    private Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        Stack<Integer> stack2 = new Stack<Integer>();
        while (!stack.empty()) {
            stack2.push(stack.pop());
        }
        stack.push(x);
        while (!stack2.empty()) {
            stack.push(stack2.pop());
        }
    }
    
    public int pop() {
        if (!stack.empty()) {
            return stack.pop();
        }
        return -1;
    }
    
    public int peek() {
        if (!stack.empty()) {
            return stack.peek();
        }
        return -1;
    }
    
    public boolean empty() {
        return stack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */