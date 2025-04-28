class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int maxSum = Integer.MIN_VALUE;
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (runningSum < 0 && nums[i] > runningSum) {
                runningSum = 0;
            }
            runningSum += nums[i];
            maxSum = Math.max(maxSum, runningSum);
        }
        return maxSum;
    }
}