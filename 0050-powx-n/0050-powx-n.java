class Solution {
    public double myPow(double x, int n) {
        long nLong = n;
        if (nLong < 0) {
            x = 1 / x;
            nLong = -nLong;
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

// time  - O(log n)
// space - O(1)

// x = 2.0   n = 10      result = 1.0;
// x = 4.0   n = 5       result = 1.0;
// x = 16.0  n = 2       result = 4.0;
// x = 256.0 n = 1       result = 4.0;
// x = 256.0 n = 0       result = 1024.0;
