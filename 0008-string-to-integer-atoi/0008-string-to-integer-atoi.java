class Solution {
    public int myAtoi(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        int index = 0;
        
        // remove leading whitespaces
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        // get sign
        int sign = 1;
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            if (s.charAt(index) == '-') {
                sign = -1;
            }
            index++;
        }

        // get number
        int number = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if (!isWithinBounds(number, digit, sign)) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            number = number * 10 + digit;
            index++;
        }

        return sign * number;
    }

    private static boolean isWithinBounds(int number, int digit, int sign) {
        return (number < Integer.MAX_VALUE / 10) || (number == Integer.MAX_VALUE / 10 && digit <= 7);
    }
}

// time  - O(n)
// space - O(1)