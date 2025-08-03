class Solution {
    public int findComplement(int num) {
        int numCopy = num;
        int bitmask = 0;
        while (numCopy > 0) {
            bitmask <<= 1;
            bitmask += 1;
            numCopy >>= 1;
        }
        return bitmask - num;
    }
}

// time  - O(log n)
// space - O(1)
