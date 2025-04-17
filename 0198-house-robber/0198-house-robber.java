class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] memo = new int[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return Math.max(rob(nums, 0, memo), rob(nums, 1, memo));
    }

    private int rob(int[] nums, int i, int[] memo) {
        if (i > nums.length - 1) return 0;

        if (memo[i] != -1) return memo[i];

        int result = nums[i] + Math.max(rob(nums, i + 2, memo), rob(nums, i + 3, memo));
        memo[i] = result;
        return result;
    }
}