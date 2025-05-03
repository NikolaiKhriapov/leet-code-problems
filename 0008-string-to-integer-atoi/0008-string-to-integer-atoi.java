class Solution {
    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }

        s = s.trim();

        if (s.isEmpty()) {
            return 0;
        }

        boolean isNegative = false;
        int index = 0;
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            if (s.charAt(index) == '-') {
                isNegative = true;
            }
            index++;
        }

        long number = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if ((number > Integer.MAX_VALUE / 10) || (number == Integer.MAX_VALUE / 10 && digit > (isNegative ? 8 : 7))) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            number = number * 10 + digit;
            index++;
        }
        
        return isNegative ? (int) -number : (int) number;
    }
}