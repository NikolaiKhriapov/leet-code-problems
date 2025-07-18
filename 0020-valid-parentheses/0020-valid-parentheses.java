class Solution {
    private static final String OPENING_BRACKETS = "({[";
    private static final String CLOSING_BRACKETS = ")}]";

    public boolean isValid(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (s.isBlank()) {
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (OPENING_BRACKETS.indexOf(c) != -1) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || OPENING_BRACKETS.indexOf(stack.peek()) != CLOSING_BRACKETS.indexOf(c)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

// time  - O(n)
// space - O(n)