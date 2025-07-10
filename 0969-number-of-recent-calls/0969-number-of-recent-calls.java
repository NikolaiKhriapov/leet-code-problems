class RecentCounter {
    List<Integer> list;

    public RecentCounter() {
        list = new ArrayList<>();
    }
    
    public int ping(int t) {
        while (!list.isEmpty() && list.get(0) < t - 3000) {
            list.remove(0);
        }
        list.add(t);
        return list.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */