class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int start = binarySearchStart(nums, target, 0, nums.length - 1);
        int end = -1;
        if (start != -1) {
            end = binarySearchEnd(nums, target, start, nums.length - 1);
        }
        return new int[] {start, end};
    }

    private int binarySearchStart(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target && (mid == left || nums[mid - 1] < target)) {
                return mid;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    private int binarySearchEnd(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target && (mid == right || nums[mid + 1] > target)) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

// time  - O(log n)
// space - O(1)