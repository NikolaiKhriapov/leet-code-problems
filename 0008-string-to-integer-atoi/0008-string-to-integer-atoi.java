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
        
        // build number as StringBuilder
        int number = 0;
        StringBuilder sb = new StringBuilder();
        while (p < s.length() && Character.isDigit(s.charAt(p))) {
            sb.append(s.charAt(p));
            if (Long.parseLong(sb.toString()) > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                number = Integer.parseInt(sb.toString());
            }
            p++;
        }
        
        return isNegative ? -number : number;
    }
}