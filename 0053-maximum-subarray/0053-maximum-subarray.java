class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }

        int maxSum = Integer.MIN_VALUE;
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (runningSum < 0) {
                runningSum = 0;
            }
            runningSum += nums[i];
            maxSum = Math.max(maxSum, runningSum);
        }
        return maxSum;
    }
}