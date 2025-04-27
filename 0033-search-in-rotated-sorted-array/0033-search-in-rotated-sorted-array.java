class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }

        int m = l + (r - l) / 2;

        if (nums[m] == target) return m;

        boolean isLeftSorted = nums[l] <= nums[m];
        if (isLeftSorted) {
            if (nums[l] <= target && target < nums[m]) {
                return binarySearch(nums, target, l, m - 1);
            } else {
                return binarySearch(nums, target, m + 1, r);
            }
        } else {
            if (nums[m] < target && target <= nums[r]) {
                return binarySearch(nums, target, m + 1, r);
            } else {
                return binarySearch(nums, target, l, m - 1);
            }
        }
    }
}