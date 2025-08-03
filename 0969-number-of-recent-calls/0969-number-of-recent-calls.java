class RecentCounter {
    private Queue<Integer> queue;
    
    private static final int RANGE = 3000;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        while (!queue.isEmpty() && t - RANGE > queue.peek()) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }
}

// time  - O(n)
// space - O(n)