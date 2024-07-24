class Solution {
    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];

        int pl = 0;
        int pr = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[pr]) > Math.abs(nums[pl])) {
                result[i] = nums[pr] * nums[pr];
                pr--;
            } else {
                result[i] = nums[pl] * nums[pl];
                pl++;
            }
        }

        return result;
    }
}