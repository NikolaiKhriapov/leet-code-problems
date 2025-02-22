class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        boolean[] boxesAlice = new boolean[100001];
        int totalAlice = 0;
        int totalBob = 0;

        for (int n : aliceSizes) {
            totalAlice += n;
            boxesAlice[n] = true;
        }
        for (int n : bobSizes) {
            totalBob += n;
        }

        for (int n : bobSizes) {
            int complement = (totalAlice - totalBob) / 2 + n;
            if (complement >= 0 && complement < boxesAlice.length && boxesAlice[complement]) {
                return new int[] {complement, n};
            }
        }
        
        return new int[] {-1, -1};
    }
}
