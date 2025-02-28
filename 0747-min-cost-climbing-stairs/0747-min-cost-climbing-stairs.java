class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> map = new HashMap<>();
        return Math.min(helper(cost, 0, map), helper(cost, 1, map));
    }

    private int helper(int[] cost, int step, Map<Integer, Integer> map) {
        if (step >= cost.length) return 0;

        if (map.containsKey(step)) return map.get(step);

        int result = cost[step] + Math.min(helper(cost, step + 1, map), helper(cost, step + 2, map));
        map.put(step, result);
        return result;
    }
}