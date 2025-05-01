class Solution {
    private static final Set<Character> OPERATIONS = Set.of('*', '/', '+', '-');

    public int calculate(String s) {
        if (s == null) return -1;
        s = s.replaceAll(" ", "");
        if (s.isEmpty()) return -1;

        Stack<Integer> stack = new Stack<>();
        
        char operation = '+';
        int number = 0;
        for (char c : s.toCharArray()) {
            if (OPERATIONS.contains(c)) {
                stack.add(number);
                number = 0;
                if (operation == '-') {
                    stack.add(stack.pop() * -1);
                } else if (operation == '*' || operation == '/') {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.add(calculate(a, b, operation));
                }
                operation = c;
            } else {
                number = number * 10 + (c - '0');
            }
        }
        if (operation == '-') {
            stack.add(-number);
        } else {
            stack.add(number);
        }
        if (stack.size() > 1 && (operation == '*' || operation == '/')) {
            int b = stack.pop();
            int a = stack.pop();
            stack.add(calculate(a, b, operation));
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    private static int calculate(int a, int b, char operation) {
        return switch (operation) {
            case '*' -> a * b;
            case '/' -> a / b;
            case '+' -> a + b;
            case '-' -> a - b;
            default -> throw new IllegalArgumentException("Invalid operation: " + operation);
        };
    }
}