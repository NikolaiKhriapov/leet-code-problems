class RecentCounter {

    Stack<Integer> stack;

    public RecentCounter() {
        stack = new Stack<>();
    }
    
    public int ping(int t) {
        stack.add(t);
        
        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {
            Integer el = stack.pop();
            if (t - el <= 3000) {
                temp.add(el);
            }
        }

        stack = temp;

        return stack.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */