class Solution {
    public int reverse(int x) {
        if (x >= 0 && x <= 9) {
            return x;
        }
        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        int sign = x < 0 ? -1 : 1;
        int xPos = Math.abs(x);

        int xReversed = 0;
        while (xPos > 0) {
            int digit = xPos % 10;
            if (xReversed > Integer.MAX_VALUE / 10 || xReversed == Integer.MAX_VALUE / 10 && digit >= 7) {
                return 0;
            }
            xReversed = xReversed * 10 + digit;
            xPos /= 10;
        }

        return sign * xReversed;
    }
}