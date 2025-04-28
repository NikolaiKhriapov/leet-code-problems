class Solution {
    public void sortColors(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        if (nums.length <= 1) {
            return;
        }

        int left = 0;
        int current = left;
        int right = nums.length - 1;
        
        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, current, left);
                left++;
                current++;
            } else if (nums[current] == 2) {
                swap(nums, current, right);
                right--;
            } else {
                current++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}