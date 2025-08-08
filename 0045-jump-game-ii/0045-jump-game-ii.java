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
            if (i == currReachable) {
                jumpsCount++;
                currReachable = maxReachable;
            }
            if (currReachable >= nums.length - 1) {
                break;
            }

        }
        return jumpsCount;
    }
}

// time  - O(n)
// space - O(1)