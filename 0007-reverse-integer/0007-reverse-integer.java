class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        
        int result = 0;
        int n = Math.abs(x);

        while (n > 0) {
            int digit = n % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            n /= 10;
            result = result * 10 + digit;
        }
        
        return x >= 0 ? result : -result;
    }
}

// time  - O(log 10 n)
// space - O(1)