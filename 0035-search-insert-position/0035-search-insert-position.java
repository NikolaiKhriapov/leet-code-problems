class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        if (l > r) {
            return l;
        }

        int m = l + (r - l) / 2;

        if (nums[m] == target) {
            return m;
        }
        if (nums[m] > target) {
            return binarySearch(nums, l, m - 1, target);
        } else {
            return binarySearch(nums, m + 1, r, target);
        }
    }
}