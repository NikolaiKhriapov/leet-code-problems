class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length + 1];
        return Math.min(calcCost(cost, 0, memo), calcCost(cost, 1, memo));
    }

    private int calcCost(int[] cost, int n, int[] memo) {
        if (n >= cost.length) {
            return 0;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        int constOneStep = calcCost(cost, n + 1, memo);
        int constTwoSteps = calcCost(cost, n + 2, memo);

        int subTotal = cost[n] + Math.min(constOneStep, constTwoSteps);
        memo[n] = subTotal;

        return subTotal;
    }
}