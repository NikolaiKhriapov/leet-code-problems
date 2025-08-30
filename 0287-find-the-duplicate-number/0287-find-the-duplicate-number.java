class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Invalid input");
        }

        int first = nums[0];
        int second = nums[0];

        first = nums[first];
        second = nums[nums[second]];
        while (first != second) {
            first = nums[first];
            second = nums[nums[second]];
        }

        second = nums[0];
        while (first != second) {
            first = nums[first];
            second = nums[second];
        }

        return first;
    }
}

// time  - O(n)
// space - O(1)