class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (cost.length <= 1) {
            return 0;
        }

        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[dp.length - 1];
    }
}

// [  1,100,  1,  1,  1,100,  1,  1,100,  1]
// [  0,  0,  1,  2,  2,  3,  3,  4,  4,  5,  6]