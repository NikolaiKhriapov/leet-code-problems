class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (nums.length <= 1) {
            return nums.length;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int longestCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(n - 1)) {
                continue;
            }
            int count = 0;
            while (map.containsKey(n + count)) {
                map.remove(n + count);
                count++;
            }
            longestCount = Math.max(longestCount, count);
        }
        
        return longestCount;
    }
}