class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int aliceTotal = 0;
        for (int n : aliceSizes) {
            aliceTotal += n;
        }
        Set<Integer> set = new HashSet<>();
        int bobTotal = 0;
        for (int n : bobSizes) {
            set.add(n);
            bobTotal += n;
        }

        for (int i = 0; i < aliceSizes.length; i++) {                
            int aliceGives = aliceSizes[i];
            int aliceNeeds = ((bobTotal + aliceGives) - (aliceTotal - aliceGives)) / 2;

            if (set.contains(aliceNeeds)) return new int[] { aliceGives, aliceNeeds };
        }
        
        return new int[] { -1, -1 };
    }
}