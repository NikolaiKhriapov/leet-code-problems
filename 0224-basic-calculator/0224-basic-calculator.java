class Solution {
    public int calculate(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int number = 0;
        int result = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                sign = 1;
                number = 0;
            } else if (ch == '-') {
                result += sign * number;
                sign = -1;
                number = 0;
            } else if (ch == '(') {
                stack.add(result);
                stack.add(sign);
                result = 0;
                sign = 1;
                number = 0;
            } else if (ch == ')') {
                result += sign * number;
                result *= stack.pop();
                result += stack.pop();
                sign = 1;
                number = 0;
            }
        }
        
        result += sign * number;
        return result;
    }
}