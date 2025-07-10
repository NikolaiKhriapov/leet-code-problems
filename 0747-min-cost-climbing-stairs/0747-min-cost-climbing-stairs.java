class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(helper(cost, 0, memo), helper(cost, 1, memo));
    }

    private int helper(int[] cost, int idx, int[] memo) {
        if (idx >= cost.length) {
            return 0;
        }
        if (memo[idx] != -1) {
            return memo[idx];
        }

        int result = cost[idx] + Math.min(helper(cost, idx + 1, memo), helper(cost, idx + 2, memo));
        memo[idx] = result;
        return result;
    }
}