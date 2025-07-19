public class Solution {
    public int reverseBits(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += (n & 1);
            n >>= 1;
        }
        return result;
    }
}

// time  - O(1)
// space - O(1)