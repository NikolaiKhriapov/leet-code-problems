class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        int xPos = Math.abs(x);

        int result = 0;
        while (xPos > 0) {
            int digit = xPos % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > (sign == 1 ? 7 : 8))) {
                return 0;
            }
            result = result * 10 + digit;
            xPos /= 10;
        }
        
        return sign * result;
    }
}