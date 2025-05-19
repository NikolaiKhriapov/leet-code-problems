class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length || gas.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int totalGas = 0;
        int currentGas = 0;
        int startingStation = 0;
        for (int i = 0; i < gas.length; i++) {
            int gasGain = gas[i] - cost[i];
            currentGas += gasGain;
            totalGas += gasGain;
            if (currentGas < 0) {
                currentGas = 0;
                startingStation = i + 1;
            }
        }
        return totalGas >= 0 ? startingStation : - 1;

    }
}