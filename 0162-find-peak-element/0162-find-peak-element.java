class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }

        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (mid != 0 && nums[mid] < nums[mid - 1]) {
            return helper(nums, left, mid - 1);
        }
        if (mid != nums.length - 1 && nums[mid] < nums[mid + 1]) {
            return helper(nums, mid + 1, right);
        }
        return mid;
    }
}