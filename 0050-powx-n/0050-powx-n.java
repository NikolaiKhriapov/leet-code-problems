class Solution {
    public double myPow(double x, int n) {

        long nLong = n;
        if (n < 0) {
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