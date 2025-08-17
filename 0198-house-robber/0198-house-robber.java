class Solution {
    public int rob(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (nums.length == 0) {
            return 0;
        }

        int prev2 = 0;
        int prev1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

// time  - O(n)
// space - O(1)

// [2,1,1,2]
// [2,1,3,3]
