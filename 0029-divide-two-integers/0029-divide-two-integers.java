class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }

        int dividendNeg = dividend < 0 ? dividend : -dividend;
        int divisorNeg = divisor < 0 ? divisor : -divisor;

        int result = 0;
        while (dividendNeg <= divisorNeg) {
            int temp = divisorNeg;
            int coefficient = 1;
            while ((temp >= Integer.MIN_VALUE - temp) && (temp >= dividendNeg - temp)) {
                temp <<= 1;
                coefficient <<= 1;
            }
            dividendNeg -= temp;
            result += coefficient;
        }
        
        return sign * result;
    }
}

// time  - O(log n)
// space - O(1)