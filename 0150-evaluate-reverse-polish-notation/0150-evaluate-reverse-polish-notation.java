class Solution {
    private static final Set<String> OPERATIONS = new HashSet(Set.of("+", "-", "/", "*"));

    public int evalRPN(String[] tokens) {
        if (tokens == null) {
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
        return stack.peek();
    }

    private int applyOperation(int a, int b, String operation) {
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Invalid operation: " + operation);
        };
    }
}