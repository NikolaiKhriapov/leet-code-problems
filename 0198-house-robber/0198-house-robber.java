class Solution {
    public int rob(int[] nums) {
        
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return Math.max(helper(nums, 0, memo), helper(nums, 1, memo));
    }

    private int helper(int[] nums, int currentIndex, int[] memo) {
        if (currentIndex >= nums.length) {
            return -1;
        }

        if (memo[currentIndex] != -1) {
            return memo[currentIndex];
        }

        int sum = nums[currentIndex];

        if (currentIndex < nums.length - 2) {
            sum += Math.max(helper(nums, currentIndex + 2, memo), helper(nums, currentIndex + 3, memo));
        }

        memo[currentIndex] = sum;
        return sum;
    }
}