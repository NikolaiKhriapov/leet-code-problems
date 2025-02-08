class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int pl = 0;
        int pr = 1;

        while (pl < nums.length && pr < nums.length) {
            if (isEven(pl) && !isEven(nums[pl])) {
                while (pr < nums.length && !isEven(nums[pr])) {
                    pr += 2;
                }
                int temp = nums[pl];
                nums[pl] = nums[pr];
                nums[pr] = temp;
            }
            pl += 2;
        }

        return nums;
    }

    private boolean isEven(int n) {
        return n % 2 == 0;
    }
}