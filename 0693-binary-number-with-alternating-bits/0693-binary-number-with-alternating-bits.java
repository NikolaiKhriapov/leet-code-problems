class Solution {
    public boolean hasAlternatingBits(int n) {

        int mask = (Integer.highestOneBit(n) << 1) - 1;

        int prev = -1;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == prev) return false;
            prev = n & 1;
            n >>= 1;

            if ((mask & 1) != 1) return true;
            mask >>= 1;
        }
        
        return true;
    }
}
