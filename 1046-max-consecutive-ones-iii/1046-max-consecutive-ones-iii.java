class Solution {
    public int longestOnes(int[] nums, int k) {
        if (nums == null || k < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int longest = 0;
        int left = 0;
        int right = 0;
        int countZeroes = 0;
        
        while (right < nums.length) {
            if (nums[right] == 0) {
                countZeroes++;
            }
            right++;
            while (countZeroes > k) {
                if (nums[left] == 0) {
                    countZeroes--;
                }
                left++;
            }
            longest = Math.max(longest, right - left);
        }

        return longest;
    }
}