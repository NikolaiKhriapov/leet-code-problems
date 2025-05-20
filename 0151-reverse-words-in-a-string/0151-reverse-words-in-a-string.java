class Solution {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int r = s.length() - 1;
        int l = r;
        while (r >= 0) {
            while (r >= 0 && s.charAt(r) == ' ') {
                r--;
            }

            if (r < 0) {
                break;
            }

            l = r;
            while (l >= 0 && s.charAt(l) != ' ') {
                l--;
            }

            result.append(s.substring(l + 1, r + 1)).append(" ");
            r = l;
        }

        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        
        return result.toString();
    }
}