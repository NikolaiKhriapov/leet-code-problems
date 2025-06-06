class Solution {
    private static final Set<String> OPERATIONS = Set.of("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (OPERATIONS.contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(applyOperation(a, b, token));
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private Integer applyOperation(int a, int b, String operation) {
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Invalid operation: " + operation);
        };
    }
}