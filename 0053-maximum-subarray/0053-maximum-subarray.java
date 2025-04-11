class Solution {
    public int maxSubArray(int[] nums) {
        int sumMax = Integer.MIN_VALUE;
        int p = 0;

        int sum = 0;
        for (int n : nums) {
            sum += n;
            sumMax = Math.max(sumMax, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return sumMax;
    }
}