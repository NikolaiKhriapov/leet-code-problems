class Solution {
    public void moveZeroes(int[] nums) {
        int pl = 0;
        int pr = 0;
        
        while (pl < nums.length && pr < nums.length) {
            while (pl < nums.length && nums[pl] != 0) {
                pl++;
            }
            if (pl == nums.length) return;
            while (pr < pl || (pr < nums.length && nums[pr] == 0)) {
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