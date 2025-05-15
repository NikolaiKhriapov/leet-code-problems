class LRUCache {
    private int capacity;
    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity, 0.75f, true);
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        map.put(key, value);
        updateCapacity();
    }

    private void updateCapacity() {
        if (map.size() > capacity) {
            Integer key = map.keySet().iterator().next();
            map.remove(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */