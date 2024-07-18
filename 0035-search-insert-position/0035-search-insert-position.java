class Solution {
    public int searchInsert(int[] nums, int target) {
        
        return findIndex(nums, target, 0, nums.length - 1);

    }

    public int findIndex(int[] nums, int target, int l, int r) {
        if (l > r) return l;

        int m = l + (r - l) / 2;

        if (nums[m] == target) return m;
        if (nums[m] < target) return findIndex(nums, target, m + 1, r);
        else return findIndex(nums, target, 0, m - 1);
    }
}