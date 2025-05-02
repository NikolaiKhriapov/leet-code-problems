class Solution {
    public int reverse(int x) {
        if (x >= 0 && x <= 9) {
            return x;
        }

        int sign = x < 0 ? -1 : 1;
        long xPos = Math.abs((long) x);

        long xReversed = 0;
        while (xPos > 0) {
            int digit = (int) (xPos % 10);
            xPos /= 10;
            xReversed = xReversed * 10 + digit;
        }

        long result = sign * xReversed;
        if (xReversed >= Integer.MAX_VALUE || xReversed <= Integer.MIN_VALUE) {
            result = 0;
        }
        return (int) result;
    }
}