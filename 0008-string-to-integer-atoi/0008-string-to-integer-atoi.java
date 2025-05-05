class Solution {
    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }

        if (s.isEmpty()) {
            return 0;
        }

        int index = 0;
        
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        int sign = 1;
        if (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            if (s.charAt(index) == '-') {
                sign = -1;
            }
            index++;
        }

        int result = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }
        
        return sign * result;
    }
}