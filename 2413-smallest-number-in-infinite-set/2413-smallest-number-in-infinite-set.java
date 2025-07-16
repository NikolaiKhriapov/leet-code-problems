class SmallestInfiniteSet {
    private Set<Integer> set;
    // private Queue<Integer> queue;

    public SmallestInfiniteSet() {
        set = new HashSet<>();
    }
    
    public int popSmallest() {
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) {
                set.add(i);
                return i;
            }
        }
        throw new RuntimeException("No more positive numbers");
    }
    
    public void addBack(int num) {
        set.remove(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */