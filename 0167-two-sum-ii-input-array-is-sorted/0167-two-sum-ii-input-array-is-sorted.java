class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement) + 1, i + 1};
            } else {
                map.put(numbers[i], i);
            }
        }
        
        throw new IllegalArgumentException("Invalid input");
    }
}

// time  - O(n)
// space - O(n)