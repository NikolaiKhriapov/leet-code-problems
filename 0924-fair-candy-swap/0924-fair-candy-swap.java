class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int aliceTotal = 0;
        for (int n : aliceSizes) {
            aliceTotal += n;
        }

        boolean[] set = new boolean[100001];
        int bobTotal = 0;
        for (int n : bobSizes) {
            set[n] = true;
            bobTotal += n;
        }

        for (int aliceGives : aliceSizes) {                
            int aliceNeeds = (bobTotal - aliceTotal) / 2 + aliceGives;
            if (aliceNeeds > 0 && aliceNeeds < set.length && set[aliceNeeds]) {
                return new int[] { aliceGives, aliceNeeds };
            }
        }
        
        return new int[] { -1, -1 };
    }
}