class Solution {
    public int divide(int dividend, int divisor) {
        // handle overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int result = 0;

        // to avoid overflow
        long dividendPos = Math.abs((long) dividend);
        long divisorPos = Math.abs((long) divisor);

        while (dividendPos >= divisorPos) {
            long temp = divisorPos;
            int multiple = 1;
            while (dividendPos >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dividendPos -= temp;
            result += multiple;
        }
        
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        return isNegative ? -result : result;
    }
}