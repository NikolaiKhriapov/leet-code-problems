class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = -x;
        }

        int result = 0;

        while (x > 0) {
            int digit = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            x /= 10;
            result = result * 10 + digit;
        }
        
        return sign * result;
    }
}

// time  - O(log 10 n)
// space - O(1)