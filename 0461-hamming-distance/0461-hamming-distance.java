class Solution {
    public int hammingDistance(int x, int y) {
        int hammingDistance = 0;
        while (x > 0 || y > 0) {
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