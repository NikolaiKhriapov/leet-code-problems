class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean isTrailing = false;
        int prev = -1;
        for (int i = 0; i < 32; i++) {
            int last = (n & 1);
            if (!isTrailing) {
                if (last != prev) {
                    prev = last;
                } else {
                    if (last != 0) return false;
                    isTrailing = true;
                }
            } else {
                if (last != 0) return false;
            }
            n >>= 1;
        }
        return true;
    }
}