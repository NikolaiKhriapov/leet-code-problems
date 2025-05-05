class Solution {
    public int reverse(int x) {

        int sign = x < 0 ? -1 : 1;
        long xLong = Math.abs((long) x);

        long result = 0;
        while (xLong > 0) {
            long digit = xLong % 10;
            
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > (sign == 1 ? 7 : 8))) {
                return 0;
            }

            result = result * 10 + digit;
            xLong /= 10;
        }
        
        return (int) (sign * result);
    }
}