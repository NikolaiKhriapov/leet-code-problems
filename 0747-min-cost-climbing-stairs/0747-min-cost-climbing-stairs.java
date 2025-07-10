class Solution {
    public int minCostClimbingStairs(int[] cost) {

        Map<Integer, Integer> memo = new HashMap<>();
        return Math.min(helper(cost, 0, memo), helper(cost, 1, memo));
    }

    private int helper(int[] cost, int idx, Map<Integer, Integer> memo) {
        if (idx >= cost.length) {
            return 0;
        }
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }

        int result = cost[idx] + Math.min(helper(cost, idx + 1, memo), helper(cost, idx + 2, memo));
        memo.put(idx, result);
        return result;
    }
}