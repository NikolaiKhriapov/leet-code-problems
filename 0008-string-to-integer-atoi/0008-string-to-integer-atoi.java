class Solution {
    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }

        // remove leading whitespaces
        s = s.trim();

        if (s.isEmpty()) {
            return 0;
        }

        int index = 0;
        // append sign if negative
        int sign = 1;
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            if (s.charAt(index) == '-') {
                sign = -1;
            }
            index++;
        }

        // read the integer
        int number = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if (number > Integer.MAX_VALUE / 10 || (number == Integer.MAX_VALUE / 10 && digit >= (sign == 1 ? 7 : 8))) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            number = number * 10 + digit;
            index++;
        }

        return sign * number;
    }
}