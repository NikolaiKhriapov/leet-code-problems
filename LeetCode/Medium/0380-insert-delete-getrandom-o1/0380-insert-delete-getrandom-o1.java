class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private static final Random RANDOMIZER = new Random();    

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean isAlreadyPresent = map.containsKey(val);
        if (!isAlreadyPresent) {
            map.put(val, list.size());
            list.add(val);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean remove(int val) {
        boolean isPresent = map.containsKey(val);
        if (isPresent) {
            int index = map.get(val);
            list.set(index, list.get(list.size() - 1));
            map.put(list.get(index), index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        int randomIndex = RANDOMIZER.nextInt(0, list.size());
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