class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        double maxSum = Double.NEGATIVE_INFINITY;
        double currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, currSum);
                currSum -= nums[i - k + 1];
            }
        }
        return maxSum / (double) k;
    }
}

// time  - O(n)
// space - O(1)