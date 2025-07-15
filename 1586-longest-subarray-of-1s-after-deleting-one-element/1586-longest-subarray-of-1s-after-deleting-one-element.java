class Solution {
    public int longestSubarray(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int maxCount = 0;
        while (right < nums.length) {
            if (nums[right++] == 0) {
                count++;
            }
            while (count > 1) {
                if (nums[left++] == 0) {
                    count--;
                }
            }
            maxCount = Math.max(maxCount, right - left - 1);
        }
        return maxCount;
    }
}