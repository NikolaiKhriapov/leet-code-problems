class Solution {
    public double myPow(double x, int n) {
        long nLong = (long) n;
        if (nLong < 0) {
            nLong = -nLong;
            x = 1 / x;
        }

        double result = 1;
        while (nLong > 0) {
            if (nLong % 2 == 1) {
                result *= x;
            }
            x *= x;
            nLong /= 2;
        }

        return result;
    }
}