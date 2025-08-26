class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Deque<Integer> stack = new ArrayDeque<>();

        int number = 0;
        char operation = '+';

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == ' ') {
                continue;
            } else {
                applyOperation(stack, number, operation);
                number = 0;
                operation = c;
            }
        }
        applyOperation(stack, number, operation);

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    private static void applyOperation(Deque<Integer> stack, int number, char operation) {
        switch (operation) {
            case '+' -> stack.push(number);
            case '-' -> stack.push(-number);
            case '*' -> stack.push(stack.pop() * number);
            case '/' -> stack.push(stack.pop() / number);
            default -> throw new IllegalArgumentException("Invalid input"); 
        }
    }
}

// time  - O(n)
// space - O(n)