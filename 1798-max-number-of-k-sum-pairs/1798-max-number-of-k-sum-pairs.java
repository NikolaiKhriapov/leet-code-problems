class Solution {
    public int maxOperations(int[] nums, int k) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int complement = k - n;
            if (map.containsKey(complement) && map.get(complement) > 0) {
                map.put(complement, map.get(complement) - 1);
                count++;
            } else {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }
        
        return count;
    }
}