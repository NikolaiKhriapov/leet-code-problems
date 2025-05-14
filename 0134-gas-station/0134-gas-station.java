class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        int currentTank = 0;
        int totalTank = 0;
        int startingStation = 0;
        for (int i = 0; i < gas.length; i++) {
            int gasGain = gas[i] - cost[i];
            currentTank += gasGain;
            totalTank += gasGain;

            if (currentTank < 0) {
                currentTank = 0;
                startingStation = i + 1;
            }
        }
        return totalTank >= 0 ? startingStation : -1;
    }
}