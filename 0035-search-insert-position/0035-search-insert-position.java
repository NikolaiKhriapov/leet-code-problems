class Solution {
    public int searchInsert(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    private int helper(int[] nums, int target, int l, int r) {
        if (l > r) return l;

        int m = l + (r - l) / 2;

        if (nums[m] == target) return m;
        else if (nums[m] > target) return helper(nums, target, l, m - 1);
        else return helper(nums, target, m + 1, r);
    }
}