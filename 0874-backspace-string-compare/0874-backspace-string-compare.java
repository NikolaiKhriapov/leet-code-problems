class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Objects.equals(c, '#')) {
                if (!stack1.empty()) {
                    stack1.pop();
                }
            } else stack1.push(c);
        }

        for (char c : t.toCharArray()) {
            if (Objects.equals(c, '#')) {
                if (!stack2.empty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(c);
            }
        }

        return Objects.equals(stack1, stack2);
    }
}