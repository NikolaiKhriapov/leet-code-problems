class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (target <= 0 || nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0;
        int right = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < nums.length) {
            while (right < nums.length && currentSum < target) {
                currentSum += nums[right++];
            }
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left);
                currentSum -= nums[left++];
            }
        }        
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

// time  - O(n)
// space - O(1)