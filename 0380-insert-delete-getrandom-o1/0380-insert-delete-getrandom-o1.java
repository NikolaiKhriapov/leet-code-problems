class RandomizedSet {
    private Set<Integer> set;
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private static final Random RANDOM = new Random();

    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean isAdded = set.add(val);
        if (isAdded) {
            map.put(val, list.size());
            list.add(val);
        }
        return isAdded;
    }
    
    public boolean remove(int val) {
        boolean contains = set.contains(val);
        if (contains) {
            set.remove(val);
            int listIndex = map.get(val);
            int listLast = list.get(list.size() - 1);
            list.set(listIndex, listLast);
            map.put(listLast, listIndex);
            list.remove(list.size() - 1);
            map.remove(val);
        }
        return contains;
    }
    
    public int getRandom() {
        int randomIndex = RANDOM.nextInt(0, list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */