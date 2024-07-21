class Solution {
    public int removeElement(int[] nums, int val) {

        int p = 0;
        int idx = 0;

        while (idx < nums.length) {
            if (nums[idx] == val) {
                idx++;
            } else {
                nums[p] = nums[idx];
                p++;
                idx++;
            }
        }
        
        return p;
    }
}