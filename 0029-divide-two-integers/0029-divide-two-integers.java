class Solution {
    public int divide(int dividend, int divisor) {
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
            int multiply = 1;
            while (temp >= Integer.MIN_VALUE / 2 && dividendNeg < temp + temp) {
                temp += temp;
                multiply += multiply;
            }
            dividendNeg -= temp;
            result += multiply;
        }
        
        return sign * result;
    }
}