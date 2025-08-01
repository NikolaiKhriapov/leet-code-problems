class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            } else {
                map.put(nums[i], i);
            }
        }
        
        throw new IllegalArgumentException("Invalid input");
    }
}

