class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        Map<Integer, Integer> memo = new HashMap<>();
        return Math.min(calcCost(cost, 0, memo), calcCost(cost, 1, memo));
    }

    private int calcCost(int[] cost, int n, Map<Integer, Integer> memo) {
        if (n >= cost.length) return 0;

        int a;
        if (memo.containsKey(n + 1)) a = memo.get(n + 1);
        else a = calcCost(cost, n + 1, memo);
        int b;
        if (memo.containsKey(n + 2)) b = memo.get(n + 2);
        else b = calcCost(cost, n + 2, memo);

        int subTotal = cost[n] + Math.min(a, b);
        memo.put(n, subTotal);

        return subTotal;
    }
}