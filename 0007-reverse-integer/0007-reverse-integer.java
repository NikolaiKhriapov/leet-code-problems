class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        int xNeg = x < 0 ? x : -x;

        int result = 0;
        while (xNeg < 0) {
            int digit = xNeg % 10;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit > (sign == 1 ? 7 : 8))) {
                return 0;
            }
            result = result * 10 + digit;
            xNeg /= 10;
        }
        
        return -sign * result;
    }
}
