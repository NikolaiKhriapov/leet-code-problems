class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }

        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }

        int dividendNeg = dividend < 0 ? dividend : -dividend;
        int divisorNeg = divisor < 0 ? divisor : -divisor;

        int result = 0;
        while (dividendNeg <= divisorNeg) {
            int divisorNegTemp = divisorNeg;
            int multiply = 1;
            while (divisorNegTemp >= Integer.MIN_VALUE / 2 && dividendNeg <= divisorNegTemp + divisorNegTemp) {
                divisorNegTemp <<= 1;
                multiply <<= 1;
            }
            dividendNeg -= divisorNegTemp;
            result += multiply;
        }
        
        return sign * result;
    }
}

// time  - O(log n)
// space - O(1)