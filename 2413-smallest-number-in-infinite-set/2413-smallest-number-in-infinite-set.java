class SmallestInfiniteSet {
    private int smallest;
    private Set<Integer> addedBack;
    private PriorityQueue<Integer> minHeap;

    public SmallestInfiniteSet() {
        smallest = 1;
        addedBack = new HashSet<>();
        minHeap = new PriorityQueue<>();
    }
    
    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            int min = minHeap.poll();
            addedBack.remove(min);
            return min;
        }
        return smallest++;
    }
    
    public void addBack(int num) {
        if (num < smallest && addedBack.add(num)) {
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