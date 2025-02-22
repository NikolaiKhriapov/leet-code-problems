class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Set<Integer> boxesAlice = new HashSet<>();
        int totalAlice = 0;
        int totalBob = 0;

        for (int n : aliceSizes) {
            totalAlice += n;
            boxesAlice.add(n);
        }
        for (int n : bobSizes) {
            totalBob += n;
        }

        for (int n : bobSizes) {
            int complement = (totalAlice - totalBob) / 2 + n;
            if (boxesAlice.contains(complement)) {
                return new int[] {complement, n};
            }
        }
        
        return new int[] {-1, -1};
    }
}
