class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();

        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            
            if (c == '(') {
                counter++;
            } else {
                counter--;
            }

            if (counter == 0) {
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length() - 1);
                result.append(sb);
                sb = new StringBuilder();
            }
        }

        return result.toString();
    }
}