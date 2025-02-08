class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int pl = 0;
        int pr = 1;

        while (pl < nums.length - 1) {
            if (isEven(pl)) {
                if (!isEven(nums[pl])) {
                    while (pr < nums.length && !isEven(nums[pr])) {
                        pr++;
                    }
                    int temp = nums[pl];
                    nums[pl] = nums[pr];
                    nums[pr] = temp;
                }
            } else {
                if (isEven(nums[pl])) {
                    while (pr < nums.length && isEven(nums[pr])) {
                        pr++;
                    }
                    int temp = nums[pl];
                    nums[pl] = nums[pr];
                    nums[pr] = temp;
                }
            }
            pl++;
            pr = pl + 1;
        }

        return nums;
    }

    private boolean isEven(int n) {
        return n % 2 == 0;
    }
}