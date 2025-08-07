class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            boolean isLeftHalfSorted = left < mid && nums[left] <= nums[mid - 1];
            if (isLeftHalfSorted) {
                if (nums[left] <= target && nums[mid - 1] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (mid < right && nums[mid + 1] <= target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

// [3,1]
//  -

// time  - O(log n)
// space - O(1)