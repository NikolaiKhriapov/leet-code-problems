class Solution {
    private static final int NUMBER_TO_SKIP = 0;

    public void moveZeroes(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (nums.length <= 1) {
            return;
        }

        int left = 0;
        int right = 0;
        while (right < nums.length) {
            while (right < nums.length && nums[right] == NUMBER_TO_SKIP) {
                right++;
            }
            if (right < nums.length) {
                nums[left++] = nums[right++];
            }
        }
        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

// time  = O(n)
// space = O(1)