class Solution {
    private static final Set<String> OPERATIONS = new HashSet(Set.of("+", "-", "/", "*"));

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 2) {
            throw new IllegalArgumentException("Invalid input");
        }

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (OPERATIONS.contains(token)) {
                stack.add(applyOperation(stack.pop(), stack.pop(), token));
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    private int applyOperation(int a, int b, String operation) {
        return switch (operation) {
            case "+" -> b + a;
            case "-" -> b - a;
            case "*" -> b * a;
            case "/" -> b / a;
            default -> throw new IllegalArgumentException("Invalid operation: " + operation);
        };
    }
}