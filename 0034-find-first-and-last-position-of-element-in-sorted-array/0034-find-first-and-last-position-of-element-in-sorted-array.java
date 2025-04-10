class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = binarySearchLeft(nums, target, 0, nums.length - 1);
        
        int r = -1;
        if (l != -1) {
            r = binarySearchRight(nums, target, l, nums.length - 1);
        }

        return new int[] {l, r};
    }

    private int binarySearchLeft(int[] nums, int target, int l, int r) {
        if (l > r) return -1;

        int m = l + (r - l) / 2;
        
        if (nums[m] == target) {
            if (m == 0 || nums[m - 1] < nums[m]) return m;
            else return binarySearchLeft(nums, target, l, m - 1);
        }
        
        if (nums[m] > target) {
            return binarySearchLeft(nums, target, l, m - 1);
        } else {
            return binarySearchLeft(nums, target, m + 1, r);
        }
    }

    private int binarySearchRight(int[] nums, int target, int l, int r) {
        int m = l + (r - l) / 2;
        
        if (nums[m] == target) {
            if (m == nums.length - 1 || nums[m + 1] > nums[m]) return m;
            else return binarySearchRight(nums, target, m + 1, r);
        }
        
        return binarySearchRight(nums, target, l, m - 1);
    }
}