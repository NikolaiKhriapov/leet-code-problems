class Solution {
    public int hammingWeight(int n) {
        int countSetBits = 0;
        for (int i = 0; i < 32; i++) {
            countSetBits += (n & 1);
            n >>= 1;
        }
        return countSetBits;
    }
}

// time. - O(1)
// space - O(1)