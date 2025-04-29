class Solution {
    public int findPeakElement(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int l, int r) {
        if (l > r) return -1;

        int m = l + (r - l) / 2;

        if (m != 0 && nums[m] < nums[m - 1]) return helper(nums, l, m - 1);
        if (m != nums.length - 1 && nums[m] < nums[m + 1]) return helper(nums, m + 1, r);

        return m;
    }
}