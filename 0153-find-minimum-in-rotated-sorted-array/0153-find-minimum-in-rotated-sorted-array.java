class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            
            if ((m == 0 && nums[m] <= nums[r]) || (m > 0 && nums[m] < nums[m - 1])) {
                return nums[m];
            }
            
            if (nums[m] < nums[r]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}