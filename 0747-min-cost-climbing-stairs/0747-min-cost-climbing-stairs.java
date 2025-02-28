class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(helper(cost, 0), helper(cost, 1));
    }

    private int helper(int[] cost, int step) {
        if (step >= cost.length) return 0;

        if (map.containsKey(step)) return map.get(step);

        int result = cost[step] + Math.min(helper(cost, step + 1), helper(cost, step + 2));
        map.put(step, result);
        return result;
    }
}