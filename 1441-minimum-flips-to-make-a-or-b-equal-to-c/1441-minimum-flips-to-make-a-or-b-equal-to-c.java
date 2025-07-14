class Solution {
    public int minFlips(int a, int b, int c) {
        int flipsCount = 0;
        while (a != 0 || b != 0 || c != 0) {
            if ((c & 1) == 0) {
                if ((a & 1) == 1) flipsCount++;
                if ((b & 1) == 1) flipsCount++;
            } else {
                if ((a & 1) == 0 && (b & 1) == 0) flipsCount++;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return flipsCount;
    }
}