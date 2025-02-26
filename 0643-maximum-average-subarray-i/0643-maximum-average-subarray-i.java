class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0;
        int r = k - 1;

        double maxAverage = Long.MIN_VALUE;
        double prevSum = 0;

        while (r < nums.length) {
            double sum;
            if (prevSum == 0) sum = helper(nums, l, r);
            else sum = prevSum - nums[l - 1] + nums[r];
            prevSum = sum;

            maxAverage = Math.max(maxAverage, (sum) / ((double) (r - l + 1)));
            l++;
            r++;
        }

        return maxAverage;
    }

    private double helper(int[] arr, int l, int r) {
        double result = 0;
        for (int i = l; i <= r; i++) {
            result += arr[i];
        }
        return result;
    }
}