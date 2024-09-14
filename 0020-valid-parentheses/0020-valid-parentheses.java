class Solution {
    public boolean isValid(String s) {
        String opening = "({[";
        String closing = ")}]";
        Stack<Character> stack = new Stack();

        for (char c : s.toCharArray()) {
            if (opening.indexOf(c) != -1) {
                stack.push(c);
            } else if (stack.empty()) {
                return false;
            } else {
                int index = opening.indexOf(stack.pop());
                if (closing.charAt(index) != c) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}