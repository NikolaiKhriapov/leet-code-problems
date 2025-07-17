class Solution {
    public int minFlips(int a, int b, int c) {
        int flipCount = 0;
        while (a != 0 || b != 0 || c != 0) {
            if ((c & 1) == 0) {
                if ((a & 1) == 1) flipCount++;
                if ((b & 1) == 1) flipCount++;
            } else {
                if ((a & 1) == 0 && (b & 1) == 0) flipCount++;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return flipCount;
    }
}