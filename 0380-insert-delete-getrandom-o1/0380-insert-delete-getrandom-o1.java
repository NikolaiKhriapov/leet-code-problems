class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private static final Random RANDOM = new Random();

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if (!contains) {
            map.put(val, list.size());
            list.add(val);
        }
        return !contains;
    }
    
    public boolean remove(int val) {
        boolean contains = map.containsKey(val);
        if (contains) {
            int index = map.get(val);
            int listLast = list.get(list.size() - 1);
            list.set(index, listLast);
            list.remove(list.size() - 1);
            map.put(listLast, index);
            map.remove(val);
        }
        return contains;
    }
    
    public int getRandom() {
        int index = RANDOM.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */