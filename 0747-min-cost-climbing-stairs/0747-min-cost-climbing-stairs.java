class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] map = new int[cost.length + 1];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        return Math.min(helper(cost, 0, map), helper(cost, 1, map));
    }

    private int helper(int[] cost, int step, int[] map) {
        if (step >= cost.length) return 0;

        if (map[step] != -1) return map[step];

        int result = cost[step] + Math.min(helper(cost, step + 1, map), helper(cost, step + 2, map));
        map[step] = result;
        return result;
    }
}