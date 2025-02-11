class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] array = new int[nums.length];

        int pl = 0;
        int pr = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[pl]) > Math.abs(nums[pr])) {
                array[i] = nums[pl] * nums[pl];
                pl++;
            } else {
                array[i] = nums[pr] * nums[pr];
                pr--;
            }
        }

        return array;   
    }
}