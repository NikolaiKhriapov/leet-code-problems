class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (i > 0) {
                    sb.append(c);
                }
                i++;
            } else {
                i--;
                if (i > 0) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}