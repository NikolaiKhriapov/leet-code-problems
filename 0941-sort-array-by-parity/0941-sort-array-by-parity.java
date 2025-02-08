class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int pl = 0;
        int pr = nums.length - 1;

        while (pl < pr) {
            while (pl < pr && isEven(nums[pl])) {
                pl++;
            }
            while (pl < pr && !isEven(nums[pr])) {
                pr--;
            }
            if (pl < pr) {
                int temp = nums[pl];
                nums[pl] = nums[pr];
                nums[pr] = temp;
            }
        }
        
        return nums;
    }

    private boolean isEven(int n) {
        return n % 2 == 0;
    }
}