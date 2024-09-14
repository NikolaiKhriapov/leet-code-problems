class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }

        int m = l + (r - l) / 2;

        if (nums[m] == target) {
            return m;
        }
        
        if (nums[m] >= nums[l]) {
            if (target >= nums[l] && target < nums[m]) {
                return search(nums, target, l, m - 1);
            } else {
                return search(nums, target, m + 1, r);
            }
        } else {
            if (target > nums[m] && target <= nums[r]) {
                return search(nums, target, m + 1, r);
            } else {
                return search(nums, target, l, m - 1);
            }
        }
    }
}
