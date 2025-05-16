class Solution {
    private static final int MAX_APPEARANCES = 2;

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (nums.length <= MAX_APPEARANCES) {
            return nums.length;
        }

        int left = MAX_APPEARANCES;
        for (int i = MAX_APPEARANCES; i < nums.length; i++) {
            if (nums[i] == nums[left - MAX_APPEARANCES]) {
                continue;
            } else {
                nums[left++] = nums[i];
            }
        }
        return left;
    }
}