class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    private int helper(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }

        int m = l + (r - l) / 2;

        if (nums[m] == target) return m;

        boolean isSortedL = nums[l] <= nums[m];
        if (isSortedL) {
            if (nums[l] <= target && target < nums[m]) {
                return helper(nums, target, l, m - 1);
            } else {
                return helper(nums, target, m + 1, r);
            }
        } else {
            if (nums[m] < target && target <= nums[r]) {
                return helper(nums, target, m + 1, r);
            } else {
                return helper(nums, target, l, m - 1);
            }
        }
    }
}