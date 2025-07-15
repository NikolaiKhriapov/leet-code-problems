class Solution {
    public int longestOnes(int[] nums, int k) {

        int longest = 0;
        int left = 0;
        int right = 0;
        int countZero = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                countZero++;
            }
            right++;
            while (countZero > k) {
                if (nums[left] == 0) {
                    countZero--;
                }
                left++;
            }
            longest = Math.max(longest, right - left);
        }
        
        return longest;
    }
}