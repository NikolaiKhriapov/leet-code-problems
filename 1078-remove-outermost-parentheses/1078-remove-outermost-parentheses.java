class Solution {
    public String removeOuterParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        int p = 0;
        int idxToRemove = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            stack.push(c);
            if (c == '(') p--;
            else p++;
            if (p == 0) {
                stack.pop();
                stack.removeElementAt(idxToRemove);
                idxToRemove = stack.size();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}