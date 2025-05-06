class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
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
            int multiple = 1;
            while (temp >= Integer.MIN_VALUE / 2 && dividendNeg <= temp + temp) {
                temp += temp;
                multiple += multiple;
            }
            dividendNeg -= temp;
            result += multiple;
        }
        
        return sign * result;
    }
}