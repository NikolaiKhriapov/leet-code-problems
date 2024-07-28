class Solution {
    public int findLHS(int[] nums) {

        Arrays.sort(nums);

        int l = 0;
        int r = 1;

        int longest = 0;
        while (r < nums.length && l < nums.length) {
            int diff = nums[r] - nums[l];
            if (diff <= 1) {
                if (diff == 1) {
                    int length = r - l + 1;
                    if (length > longest) {
                        longest = length;
                    }
                }
                r++;
            } else if (diff > 1) {
                l++;
            }
        }
        
        return longest;
    }
}