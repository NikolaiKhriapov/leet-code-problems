class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : arr) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (int val : frequencyMap.values()) {
            if (!set.add(val)) {
                return false;
            }
        }

        return true;
    }
}

// time  - O(n)
// space - O(n)