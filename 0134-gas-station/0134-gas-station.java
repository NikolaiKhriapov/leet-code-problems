class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        int currentTank = 0;
        int totalTank = 0;
        int initialStation = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            currentTank += diff;
            totalTank += diff;
            if (currentTank < 0) {
                currentTank = 0;
                initialStation = i + 1;
            }
        }
        return totalTank < 0 ? -1 : initialStation;
    }
}

// time  - O(n)
// space - O(1)
