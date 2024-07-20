class Solution {
    public String removeOuterParentheses(String s) {

        String sb = new String();
        int i = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (i != 0) sb += c;
                i++;
            } else {
                i--;
                if (i != 0) sb += c;
            }
        }

        return sb;
    }
}