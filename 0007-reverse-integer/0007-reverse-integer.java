class Solution {
    public int reverse(int x) {
        if (x >= 0 && x <= 9) {
            return x;
        }

        boolean isNegative = x < 0;

        long xLong = Math.abs((long) x);

        long xReversed = 0;
        while (xLong > 0) {
            int digit = (int) (xLong % 10);
            xLong /= 10;
            xReversed = xReversed * 10 + digit;
        }

        if (xReversed >= Integer.MAX_VALUE) {
            return 0;
        }
        return isNegative ? (int) -xReversed : (int) xReversed;
    }
}