class Solution {
    public void moveZeroes(int[] nums) {

        int p1 = 0;
        int p2 = 0;

        while (p2 < nums.length) {
            while ((nums[p2] == 0 || p2 <= p1) && p2 < nums.length - 1) p2++;
            while (nums[p1] != 0 && p1 < nums.length - 1) p1++;

            if (p2 > p1 && nums[p1] == 0 && nums[p2] != 0) {
                nums[p1] = nums[p2];
                nums[p2] = 0;
            }

            if (p2 == nums.length - 1 || p1 == nums.length - 1) break;
        }
    }
}