class Solution {
    public int maxOperations(int[] nums, int k) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int pairCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int complement = k - num;
            if (map.containsKey(complement) && map.get(complement) > 0) {
                map.put(complement, map.get(complement) - 1);
                pairCount++;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return pairCount;
    }
}