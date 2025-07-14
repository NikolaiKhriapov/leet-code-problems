class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int prevPrev = 0;
        int prev = 0;;
        for (int i = 2; i <= cost.length; i++) {
            int curr = Math.min(prevPrev + cost[i - 2], prev + cost[i - 1]);
            prevPrev = prev;
            prev = curr;
        }
        
        return prev;
    }
}