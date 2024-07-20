class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int aliceTotal = 0;
        for (int n : aliceSizes) {
            aliceTotal += n;
        }
        int bobTotal = 0;
        for (int n : bobSizes) {
            bobTotal += n;
        }

        for (int i = 0; i < aliceSizes.length; i++) {                
            int aliceGives = aliceSizes[i];
            int aliceNeeds = ((bobTotal + aliceGives) - (aliceTotal - aliceGives)) / 2;

            for (int j = 0; j < bobSizes.length; j++) {
                if (bobSizes[j] == aliceNeeds) return new int[] { aliceGives, bobSizes[j] };
            }
        }
        
        return new int[] { -1, -1 };
    }
}