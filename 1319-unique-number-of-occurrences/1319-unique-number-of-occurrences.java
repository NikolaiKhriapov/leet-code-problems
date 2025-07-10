class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (arr.length <= 1) {
            return true;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (var entry : map.entrySet()) {
            if (!set.add(entry.getValue())) {
                return false;
            }
        }
        
        return true;
    }
}