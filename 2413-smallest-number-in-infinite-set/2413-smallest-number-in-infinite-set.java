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
            int num = minHeap.poll();
            addedBack.remove(num);
            return num;
        }
        return next++;
    }
    
    public void addBack(int num) {
        if (num < next && addedBack.add(num)) {
            minHeap.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */