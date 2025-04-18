class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] memo = new int[nums.length];

        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            memo[i] = Math.max(memo[i - 1], memo[i - 2] + nums[i]);
        }

        return memo[memo.length - 1];
    }
}
