class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0;
        while (left < nums.length && nums[left] != val) {
            left++;
        }
        int right = left + 1;

        while (right < nums.length) {
            while (left < nums.length && nums[left] != val) {
                left++;
            }
            right = left + 1;
            while (right < nums.length && nums[right] == val) {
                right++;
            }
            if (right < nums.length) {
                swap(nums, left, right);
            }
        }
        return left;
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

// time  - O(n)
// space - O(1)