class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> memo = new HashMap<>();
        return Math.min(calcCost(cost, 0, memo), calcCost(cost, 1, memo));
    }

    private int calcCost(int[] cost, int n, Map<Integer, Integer> memo) {
        if (n >= cost.length) return 0;

        if (memo.containsKey(n)) return memo.get(n);

        int a = calcCost(cost, n + 1, memo);
        int b = calcCost(cost, n + 2, memo);

        int subTotal = cost[n] + Math.min(a, b);
        memo.put(n, subTotal);

        return subTotal;
    }
}