class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        if (nums.length == 1) {
            return true;
        }

        int maxReachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReachable) {
                return false;
            }
            maxReachable = Math.max(maxReachable, i + nums[i]);
            if (maxReachable >= nums.length - 1) {
                break;
            }
        }
        return true;
    }
}