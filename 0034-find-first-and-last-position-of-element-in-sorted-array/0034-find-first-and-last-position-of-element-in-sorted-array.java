class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        int l = findLeft(nums, target, 0, nums.length - 1);
        int r = findRight(nums, target, l, nums.length - 1);
        return new int[] {l, r};
    }

    private int findLeft(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }

        int m = l + (r - l) / 2;

        if (nums[m] == target) {
            if (m == 0 || nums[m - 1] < nums[m]) {
                return m;
            }
            return findLeft(nums, target, l, m - 1);
        }
        if (nums[m] > target) {
            return findLeft(nums, target, l, m - 1);
        }
        return findLeft(nums, target, m + 1, r);
    }

    private int findRight(int[] nums, int target, int l, int r) {
        if (l == - 1 || l > r) {
            return -1;
        }

        int m = l + (r - l) / 2;

        if (nums[m] == target) {
            if (m == nums.length - 1 || nums[m + 1] > nums[m]) {
                return m;
            }
            return findRight(nums, target, m + 1, r);
        }
        return findRight(nums, target, l, m - 1);
    }
}