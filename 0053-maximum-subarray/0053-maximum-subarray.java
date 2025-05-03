class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input"); //for simplicity
        }

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int n : nums) {
            sum = Math.max(sum + n, n);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
