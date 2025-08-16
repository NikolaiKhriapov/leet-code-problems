class Solution {
    private static final Set<String> OPERATIONS = Set.of("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (OPERATIONS.contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calculate(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private static int calculate(int a, int b, String operation) {
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Invalid input");
        };
    }
}

// time  - O(n)
// space - O(n)
