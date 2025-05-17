class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 || nums[mid] > nums[mid - 1]) {
                if (mid == nums.length - 1 || nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}