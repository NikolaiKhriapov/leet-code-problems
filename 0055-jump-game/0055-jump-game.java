class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int maxReachable = 0;
        for (int i = 0; i <= maxReachable; i++) {
            maxReachable = Math.max(maxReachable, i + nums[i]);
            if (maxReachable >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}

// time  - O(n)
// space - O(1)

// [3,2,1,0,4]
//        -
//        -