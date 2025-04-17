class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        Map<Integer, Integer> memo = new HashMap<>();
        return Math.max(rob(nums, 0, memo), rob(nums, 1, memo));
    }

    private int rob(int[] nums, int i, Map<Integer, Integer> memo) {
        if (i > nums.length - 1) {
            return 0;
        }

        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        int result = nums[i] + Math.max(rob(nums, i + 2, memo), rob(nums, i + 3, memo));
        memo.put(i, result);
        return result;
    }
}