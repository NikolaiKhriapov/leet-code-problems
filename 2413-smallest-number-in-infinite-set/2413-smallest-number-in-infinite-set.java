class SmallestInfiniteSet {
    private Set<Integer> set;
    private int smallest;

    public SmallestInfiniteSet() {
        set = new HashSet<>();
        smallest = 1;
    }
    
    public int popSmallest() {
        int result = smallest;
        set.add(smallest);
        while (set.contains(++smallest)) {
        }
        return result;
    }
    
    public void addBack(int num) {
        set.remove(num);
        if (num < smallest) {
            smallest = num;
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */