class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = -1;
        while (n > 0) {
            int last = (n & 1);
            if (last != prev) {
                prev = last;
            } else {
                return false;
            }
            n >>= 1;
        }
        return true;
    }
}