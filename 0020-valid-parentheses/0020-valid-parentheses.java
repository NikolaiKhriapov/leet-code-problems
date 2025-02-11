class Solution {
    public boolean isValid(String s) {
        String opening = "({[";
        String closing = ")}]";

        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (opening.indexOf(c) != -1) {
                stack.add(c);
            } else {
                if (opening.indexOf(stack.pop()) != closing.indexOf(c)) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}
