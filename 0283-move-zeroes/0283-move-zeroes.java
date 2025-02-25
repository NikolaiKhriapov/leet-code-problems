class Solution {
    public void moveZeroes(int[] nums) {
        int pl = 0;
        int pr = 0;
        
        while (pl < nums.length && pr < nums.length) {
            while (pl < nums.length && nums[pl] != 0) {
                pl++;
            }
            pr = pl + 1;
            while (pr < nums.length && nums[pr] == 0 ) {
                pr++;
            }

            if (pl >= nums.length || pr >= nums.length) {
                return;
            }

            int temp = nums[pl];
            nums[pl] = nums[pr];
            nums[pr] = temp;
        }
    }
}