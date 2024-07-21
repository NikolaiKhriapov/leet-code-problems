class Solution {
    public int removeDuplicates(int[] nums) {

        int p = 0;
        int idx = 1;

        while (idx < nums.length) {
            if (nums[p] == nums[idx]) {
                idx++;
            } else {
                p++;
                nums[p] = nums[idx];
                idx++;
            }
        }
        
        return p + 1;
    }
}