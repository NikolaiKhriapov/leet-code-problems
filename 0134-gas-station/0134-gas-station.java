class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) {
            throw new IllegalArgumentException("Invalid input");
        } 

        int currentGas = 0;
        int totalGas = 0;
        int initialStation = 0;
        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];
            if (currentGas < 0) {
                initialStation = i + 1;
                currentGas = 0;
            }
        }
        return totalGas < 0 ? -1 : initialStation;
    }
}

// time  - O(n)
// space - O(1)
