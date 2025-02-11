class MyQueue {

    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    public void push(int x) {
        inputStack.add(x);
    }
    
    public int pop() {
        updateOutputStack();
        return outputStack.pop();
    }
    
    public int peek() {
        updateOutputStack();
        return outputStack.peek();

    }
    
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void updateOutputStack() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.add(inputStack.pop());
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