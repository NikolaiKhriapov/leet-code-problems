class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean isLeftLess = mid == 0 || nums[mid - 1] < nums[mid];
            boolean isRightLess = mid == nums.length - 1 || nums[mid + 1] < nums[mid];
            if (isLeftLess && isRightLess) {
                return mid;
            } else if (isLeftLess) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        throw new IllegalArgumentException("Invalid input");
    }
}

// time  - O(n)
// space - O(1)