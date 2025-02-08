class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {        
        int aliceTotal = 0;
        int bobTotal = 0;

        boolean[] aliceSet = new boolean[100001];
        for (int n : aliceSizes) {
            aliceTotal += n;
            aliceSet[n] = true;
        }

        for (int n : bobSizes) {
            bobTotal += n;
        }

        for (int n : bobSizes) {
            int aliceNeedsToGive = (bobTotal - aliceTotal - 2 * n) / -2;
            if (aliceNeedsToGive > 0 && aliceNeedsToGive < aliceSet.length && aliceSet[aliceNeedsToGive]) {
                return new int[] {aliceNeedsToGive, n};
            }
        }

        return new int[] {-1, -1};
    }
}