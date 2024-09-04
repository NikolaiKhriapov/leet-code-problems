class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int l = binarySearch(nums, target, 0, nums.length - 1);
        int r = l;

        if (l != -1) {
            for (int i = l; i < nums.length; i++) {
                if (nums[i] == nums[l]) {
                    r = i;
                } else {
                    break;
                }
            }
        }

        return new int[] { l, r };
    }

    public int binarySearch(int[] nums, int target, int l, int r) {
        if (l > r) return -1;

        int m = l + (r - l) / 2;

        if (nums[m] == target) {
            if (m == 0 || nums[m - 1] < target) {
                return m;
            } else {
                return binarySearch(nums, target, l, m - 1);
            }
        }

        if (nums[m] > target) return binarySearch(nums, target, l, m - 1);
        else return binarySearch(nums, target, m + 1, r);
    }
}