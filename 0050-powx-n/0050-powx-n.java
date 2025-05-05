class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;

        long nLong = (long) n;
        if (nLong < 0) {
            x = 1 / x;
            nLong = -nLong;
        }

        double result = 1;
        while (nLong > 0) {
            if (nLong % 2 == 1) {
                result *= x;
            }
            nLong /= 2;
            x *= x;
        }
        
        return result;
    }
}