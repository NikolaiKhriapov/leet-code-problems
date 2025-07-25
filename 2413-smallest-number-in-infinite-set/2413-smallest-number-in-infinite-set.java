class SmallestInfiniteSet {
    private int next;
    private Set<Integer> addedBack;
    private PriorityQueue<Integer> minHeap;

    public SmallestInfiniteSet() {
        next = 1;
        addedBack = new HashSet<>();
        minHeap = new PriorityQueue<>();
    }
    
    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            addedBack.remove(smallest);
            return smallest;
        }
        return next++;
    }
    
    public void addBack(int num) {
        if (num < next && addedBack.add(num)) {
            minHeap.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */