class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] array = new int[nums.length];
        int p = array.length - 1;
        
        int pl = 0;
        int pr = nums.length - 1;
        
        while (pl <= pr) {
            int ls = nums[pl] * nums[pl];
            int rs = nums[pr] * nums[pr];
            if (ls > rs) {
                array[p] = ls;
                pl++;
            } else {
                array[p] = rs;
                pr--;
            }
            p--;
        }

        return array;
    }
}