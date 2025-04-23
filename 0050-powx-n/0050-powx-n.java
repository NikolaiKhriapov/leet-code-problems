class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        
        long nLong = n;
        if (nLong < 0) {
            x = 1 / x;
            nLong *= -1;
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