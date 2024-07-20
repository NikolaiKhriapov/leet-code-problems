class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder sb = new StringBuilder();

        int p = 0;
        int idxToRemove = 0;

        for (char c : s.toCharArray()) {
            sb.append(c);
            if (c == '(') p++;
            else p--;
            if (p == 0) {
                sb.deleteCharAt(idxToRemove);
                sb.deleteCharAt(sb.length() - 1);
                idxToRemove = sb.length();
            }
        }

        return sb.toString();
    }
}