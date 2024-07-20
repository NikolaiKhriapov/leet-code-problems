class Solution {
    public int searchInsert(int[] nums, int target) {

        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int l, int r) {
        if (r < l) return l;

        int m = l + ((r - l) / 2);

        if (target == nums[m]) return m;
        if (target < nums[m]) return search(nums, target, l, m - 1);
        if (target > nums[m]) return search(nums, target, m + 1, r);

        return -1;
    }
}