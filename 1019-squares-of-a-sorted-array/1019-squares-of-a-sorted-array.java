class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        
        int p = result.length - 1;
        int pl = 0;
        int pr = nums.length - 1;

        while (pl <= pr) {
            if (Math.abs(nums[pl]) >= Math.abs(nums[pr])) {
                result[p] = nums[pl] * nums[pl];
                pl++;
            } else {
                result[p] = nums[pr] * nums[pr];
                pr--;
            }
            p--;
        }

        return result;
    }
}