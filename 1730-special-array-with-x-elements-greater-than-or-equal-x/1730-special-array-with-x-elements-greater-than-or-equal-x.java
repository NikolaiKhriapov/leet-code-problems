class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i <= nums.length; i++) {
            int v = nums.length - binarySearch(nums, i, 0, nums.length - 1);
            if (v == i) return i;
        }

        return -1;
    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        if (l > r) return l;

        int m = l + (r - l) / 2;

        if (nums[m] >= target) return binarySearch(nums, target, l, m - 1);
        else return binarySearch(nums, target, m + 1, r);
    }
}