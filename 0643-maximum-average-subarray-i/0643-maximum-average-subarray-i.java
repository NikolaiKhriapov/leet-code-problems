class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxSum = Math.max(maxSum, sum);
        
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / (double) k;
    }
}