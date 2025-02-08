class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {        
        int aliceTotal = 0;
        int bobTotal = 0;

        Set<Integer> aliceSet = new HashSet<>();
        for (int n : aliceSizes) {
            aliceTotal += n;
            aliceSet.add(n);
        }

        for (int n : bobSizes) {
            bobTotal += n;
        }

        for (int n : bobSizes) {
            int aliceNeedsToGive = (bobTotal - aliceTotal - 2 * n) / -2;
            if (aliceSet.contains(aliceNeedsToGive)) {
                return new int[] {aliceNeedsToGive, n};
            }
        }

        return new int[] {-1, -1};
    }
}