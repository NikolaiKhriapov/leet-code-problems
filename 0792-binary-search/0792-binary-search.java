class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int l, int r) {
        if (r < l) return -1;

        int m = l + ((r - l) / 2);

        if (nums[m] == target) return m;
        if (nums[m] > target) return search(nums, target, 0, m - 1);
        else return search(nums, target, m + 1, r);
    }
}