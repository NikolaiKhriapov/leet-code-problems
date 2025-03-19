class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = Double.NEGATIVE_INFINITY;
        double sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                if (i >= k) {
                    sum -= nums[i - k];
                }
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum / k;
    }
}