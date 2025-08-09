class Solution {
    private static final int AMOUNT_ALLOWED = 2;

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (left < AMOUNT_ALLOWED || nums[right] != nums[left - AMOUNT_ALLOWED]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}

// time  - O(n)
// space - O(1)