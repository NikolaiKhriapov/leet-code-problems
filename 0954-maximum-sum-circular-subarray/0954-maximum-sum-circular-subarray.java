class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int totalSum = 0;
        int totalMax = nums[0];
        int currMax = 0;
        int totalMin = nums[0];
        int currMin = 0;
        for (int num : nums) {
            totalSum += num;
            currMax = Math.max(currMax + num, num);
            totalMax = Math.max(totalMax, currMax);
            currMin = Math.min(currMin + num, num);
            totalMin = Math.min(totalMin, currMin);
        }

        if (totalMax < 0) {
            return totalMax;
        }
        return Math.max(totalMax, totalSum - totalMin);
    }
}