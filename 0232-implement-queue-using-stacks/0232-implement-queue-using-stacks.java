class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.add(x);
    }
    
    public int pop() {
        updateStacks();
        return stack2.pop();
    }
    
    public int peek() {
        updateStacks();
        return stack2.peek();
    }
    
    public boolean empty() {
        updateStacks();
        return stack2.isEmpty();
    }

    private void updateStacks() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
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