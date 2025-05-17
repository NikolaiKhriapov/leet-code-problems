class Solution {
    public int rob(int[] nums) {

        Map<Integer, Integer> memo = new HashMap<>();
        return Math.max(rob(nums, 0, memo), rob(nums, 1, memo));
    }

    private int rob(int[] nums, int index, Map<Integer, Integer> memo) {
        if (index >= nums.length) {
            return 0;
        }

        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        int result = nums[index] + Math.max(rob(nums, index + 2, memo), rob(nums, index + 3, memo));
        memo.put(index, result);
        return result;
    }
}