class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int prev2 = 0;
        int prev1 = 0;

        int curr = 0;
        for (int i = 2; i <= cost.length; i++) {
            curr = Math.min(prev2 + cost[i - 2], prev1 + cost[i - 1]);
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }
}

// [  1,100,  1,  1,  1,100,  1,  1,100,  1]
// [  0,  0,  1,  2,  2,  3,  3,  4,  4,  5,  6]