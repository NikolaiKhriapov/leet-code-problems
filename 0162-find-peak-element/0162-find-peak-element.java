class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }

        return binarySearch(nums, 0, nums.length - 1);
        
    }

    private int binarySearch(int[] nums, int l, int r) {
        if (l > r) {
            return l;
        }

        int m = l + (r - l) / 2;

        if (m > 0 && nums[m] < nums[m - 1]) {
            return binarySearch(nums, l, m - 1);
        }
        if (m < nums.length - 1 && nums[m] < nums[m + 1]) {
            return binarySearch(nums, m + 1, r);
        }

        return m;
    }
}
