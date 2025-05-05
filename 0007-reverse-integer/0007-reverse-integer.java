class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        int sign = x < 0 ? -1 : 1;
        int xPos = Math.abs(x);

        int result = 0;
        while (xPos > 0) {
            int digit = xPos % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            result = result * 10 + digit;
            xPos /= 10;
        }
        
        return sign * result;
    }
}
