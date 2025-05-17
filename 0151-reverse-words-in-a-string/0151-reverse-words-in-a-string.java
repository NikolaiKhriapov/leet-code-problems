class Solution {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int right = s.length() - 1;
        int left = right;
        while (right >= 0) {
            while (right >= 0 && s.charAt(right) == ' ') {
                right--;
            }
            if (right < 0) {
                break;
            }
            
            left = right;

            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }

            sb.append(s.substring(left + 1, right + 1))
              .append(" ");
            right = left;
        }
        
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }
}