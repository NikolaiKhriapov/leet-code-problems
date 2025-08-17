class Solution {
    public int rob(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (nums.length == 0) {
            return 0;
        }

        int nextNextPrev = 0;
        int nextPrev = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = Math.max(prev, Math.max(nums[i] + nextPrev, nums[i] + nextNextPrev));
            nextNextPrev = nextPrev;
            nextPrev = prev;
            prev = curr;
        }
        return prev;
    }
}

// time  - O(n)
// space - O(1)

// [2,1,1,2]
// [2,1,3,3]
