class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (nums.length <= 1) {
            return;
        }

        int p1 = 0;
        int p2 = 0;
        while (p2 < nums.length) {
            if (nums[p2] != 0) {
                nums[p1] = nums[p2];
                p1++;
            }
            p2++;
        }
        while (p1 < nums.length) {
            nums[p1++] = 0;
        }
    }
}

// time. - O(n)
// space - O(1)
