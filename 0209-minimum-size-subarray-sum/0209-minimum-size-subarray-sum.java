class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int sum = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l++];
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}