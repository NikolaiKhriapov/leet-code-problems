class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = 0;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                sum -= nums[i - k];
            }

            sum += nums[i];
            if (i < k || (i >= k && sum > maxSum)) {
                maxSum = sum;
            }
        }
        
        return maxSum / k;
    }
}