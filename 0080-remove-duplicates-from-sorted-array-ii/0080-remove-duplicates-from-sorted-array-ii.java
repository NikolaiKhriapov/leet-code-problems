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
                swap(nums, i, left);
                left++;
            }
        }
        return left;
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}