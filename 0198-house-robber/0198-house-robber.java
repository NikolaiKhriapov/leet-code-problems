class Solution {
    public int rob(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int nextNextPrev = 0;
        int nextPrev = nums[0];
        int prev = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(prev, Math.max(nums[i] + nextPrev, nums[i] + nextNextPrev));
            nextNextPrev = nextPrev;
            nextPrev = prev;
            prev = curr;
        }
        return Math.max(prev, nextPrev);
    }
}

// time  - O(n)
// space - O(1)

// [2,1,1,2]
// [2,1,3,3]
