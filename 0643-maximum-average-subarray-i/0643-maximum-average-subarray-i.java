class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = Long.MIN_VALUE;

        int l = 0;
        int r = k - 1;

        while (r < nums.length) {
            maxAverage = Math.max(maxAverage, helper(nums, l, r));
            l++;
            r++;
        }

        return maxAverage;
    }

    private double helper(int[] arr, int l, int r) {
        int result = 0;
        for (int i = l; i <= r; i++) {
            result += arr[i];
        }
        return ((double) (result)) / ((double) (r - l + 1));
    }
}