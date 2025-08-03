class Solution {
    public int hammingDistance(int x, int y) {
        int hammingDistance = 0;
        for (int i = 0; i < 32; i++) {
            if ((x & 1) != (y & 1)) {
                hammingDistance++;
            }
            x >>= 1;
            y >>= 1;
        }
        return hammingDistance;
    }
}

// time. - O(1)
// space - O(1)