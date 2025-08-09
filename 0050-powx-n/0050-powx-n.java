class Solution {
    public double myPow(double x, int n) {
        long nLong = (long) n;
        if (nLong < 0) {
            nLong = -nLong;
        }

        double result = 1;
        while (nLong > 0) {
            double temp = x;
            int coefficient = 1;
            while ((coefficient <= Integer.MAX_VALUE - coefficient) && coefficient + coefficient <= nLong) {
                temp *= temp;
                coefficient <<= 1;
            }
            nLong -= coefficient;
            result *= temp;
        }

        return n >= 0 ? result : 1 / result;
    }
}

// time  - O(logXn)
// space - O(1)