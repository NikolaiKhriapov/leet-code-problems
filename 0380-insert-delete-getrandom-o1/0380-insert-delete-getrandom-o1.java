class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random = new Random();

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if (!contains) {
            list.add(val);
            map.put(val, list.size() - 1);
        }
        return !contains;
    }
    
    public boolean remove(int val) {
        boolean contains = map.containsKey(val);
        if (contains) {
            int idx = map.get(val);
            int lastElement = list.get(list.size() - 1);

            list.set(idx, lastElement);
            list.remove(list.size() - 1);

            map.put(lastElement, idx);
            map.remove(val);
        }
        return contains;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */