class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;

        int pl = 0;
        int pr = 1;
        
        while (pr < nums.length) {
            if (nums[pr] > nums[pl]) {
                pl++;
                int temp = nums[pl];
                nums[pl] = nums[pr];
                nums[pr] = temp;
            }
            pr++;
        }

        return pl + 1;
    }
}