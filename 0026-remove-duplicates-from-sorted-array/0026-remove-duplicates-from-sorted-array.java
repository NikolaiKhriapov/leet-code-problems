class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        
        int left = 1;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] > nums[left - 1]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        
        return left;
    }
}

// time  - O(n)
// space - O(1)