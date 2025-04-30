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
            map.put(val, list.size());
            list.add(val);
        }
        return !contains;
    }
    
    public boolean remove(int val) {
        boolean contains = map.containsKey(val);
        if (contains) {
            int index = map.get(val);
            int lastElement = list.get(list.size() - 1);

            map.put(lastElement, index);
            map.remove(val);

            list.set(index, lastElement);
            list.remove(list.size() - 1);

            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int randomNumber = random.nextInt(0, list.size());
        return list.get(randomNumber);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */