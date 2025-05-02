class Solution {
    public int reverse(int x) {
        if (x >= 0 && x <= 9) {
            return x;
        }

        boolean isNegative = x < 0;

        long xPos = Math.abs((long) x);

        long xReversed = 0;
        while (xPos > 0) {
            int digit = (int) (xPos % 10);
            xPos /= 10;
            xReversed = xReversed * 10 + digit;
        }

        if (xReversed >= Integer.MAX_VALUE) {
            return 0;
        }
        return isNegative ? (int) -xReversed : (int) xReversed;
    }
}