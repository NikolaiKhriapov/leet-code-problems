class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        int result = 0;

        long dividendPos = Math.abs((long) dividend);
        long divisorPos = Math.abs((long) divisor);

        while (dividendPos >= divisorPos) {
            long temp = divisorPos;
            int multiple = 1;

            while (dividendPos >= (temp * 2)) {
                temp *= 2;
                multiple *= 2;
            }

            dividendPos -= temp;
            result += multiple;
        }
        
        boolean isNegative;
        if (dividend < 0 && divisor < 0) isNegative = false;
        else if (dividend < 0 || divisor < 0) isNegative = true;
        else isNegative = false;

        return isNegative ? -result : result;
    }
}