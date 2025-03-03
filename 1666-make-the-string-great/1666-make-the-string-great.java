class Solution {
    public String makeGood(String s) {
        char[] sArr = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char c : sArr) {
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                if (isBad(stack.peek(), c)) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    private boolean isBad(char first, char second) {
        return first != second && Character.toLowerCase(first) == Character.toLowerCase(second);
    }
}