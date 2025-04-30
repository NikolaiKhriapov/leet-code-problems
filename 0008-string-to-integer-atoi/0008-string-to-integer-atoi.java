class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // ignore leading whitespaces
        int p = 0;
        while (p < s.length() && s.charAt(p) == ' ') {
            p++;
        }

        // save the sign
        boolean isNegative = false;
        if (p < s.length() && (s.charAt(p) == '-' || s.charAt(p) == '+')) {
            if (s.charAt(p) == '-') {
                isNegative = true;
            }
            p++;
        }
        
        // build number
        int number = 0;
        int left = p;
        int right = p;
        while (right < s.length() && Character.isDigit(s.charAt(right))) {
            if (right - left > 7 && Long.parseLong(s.substring(left, right + 1)) > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            right++;
        }
        if (right - left > 0) {
            number = Integer.parseInt(s.substring(left, right));
        }
        
        return isNegative ? -number : number;
    }
}