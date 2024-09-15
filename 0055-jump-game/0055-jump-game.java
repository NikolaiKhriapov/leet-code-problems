class Solution {
    public boolean canJump(int[] nums) {
        return recursion(nums, 0, new Boolean[10001]);
    }

    private boolean recursion(int[] nums, int index, Boolean[] memo) {
        if (index >= nums.length - 1) {
            return true;
        }
        if (nums[index] == 0) {
            return false;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        for (int i = 1; i <= nums[index]; i++) {
            if (recursion(nums, index + i, memo)) {
                return true;
            }
        }

        memo[index] = false;
        return false;
    }
}