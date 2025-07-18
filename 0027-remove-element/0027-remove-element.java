class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (left < nums.length && nums[left] != val) {
                left++;
            }
            while (left < right && nums[right] == val) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                nums[right] = val;
            }
            if (left == right) {
                return left;
            }
        }
        return left;
    }
}

// time  - O(n)
// space - O(1)
