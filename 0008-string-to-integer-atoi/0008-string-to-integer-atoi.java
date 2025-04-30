class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        if (s.isEmpty()) {
            return 0;
        }

        int index = 0;
        boolean isNegative = false;
        // save the sign
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            if (s.charAt(index) == '-') {
                isNegative = true;
            }
            index++;
        }
        
        // build number
        int number = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if (number > (Integer.MAX_VALUE - digit) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            number = number * 10 + digit;
            index++;
        }
        
        return isNegative ? -number : number;
    }
}