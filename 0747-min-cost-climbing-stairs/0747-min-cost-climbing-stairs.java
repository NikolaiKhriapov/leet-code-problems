class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (cost.length <= 1) {
            return 0;
        }

        int prev2 = cost[0];
        int prev1 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int curr = cost[i] + Math.min(prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1, prev2);
    }
}

// time  - O(n)
// space - O(1)