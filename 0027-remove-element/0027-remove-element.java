class Solution {
    public int removeElement(int[] nums, int val) {
        int pl = 0;
        int pr = nums.length - 1;

        while (pr >= pl) {
            while (pl < nums.length && nums[pl] != val) {
                pl++;
            }

            while (pr > pl && nums[pr] == val) {
                pr--;
            }

            if (pl < pr) {
                nums[pl] = nums[pr];
                nums[pr] = val;
            }

            if (pl == pr) return pl;
        }
        
        return pl;
    }
}