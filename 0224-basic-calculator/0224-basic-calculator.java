class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }

        int result = 0;
        int number = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                result += number * sign;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += number * sign;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.add(result);
                stack.add(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                result *= stack.pop();
                result += stack.pop();
                number = 0;
            }
        }
        
        result += sign * number;
        return result;
    }
}