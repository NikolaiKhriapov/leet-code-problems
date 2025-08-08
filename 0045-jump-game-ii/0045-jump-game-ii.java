class Solution {
    public int jump(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (nums.length <= 1) {
            return 0;
        }

        int maxReachable = 0;
        int currReachable = 0;
        int jumpsCount = 0;
        for (int i = 0; i < nums.length; i++) {
            maxReachable = Math.max(maxReachable, i + nums[i]);
            if (maxReachable >= nums.length - 1) {
                return jumpsCount + 1;
            }
            if (i == currReachable) {
                jumpsCount++;
                currReachable = maxReachable;
            }

        }
        return -1;
    }
}

// time  - O(n)
// space - O(1)