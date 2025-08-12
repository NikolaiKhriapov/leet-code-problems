class Solution {
    public double myPow(double x, int n) {
        long nLong = n;

        if (nLong < 0) {
            x = 1 / x;
            nLong = -nLong;
        }

        double result = 1;
        while (nLong > 0) {
            if (nLong % 2 != 0) {
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