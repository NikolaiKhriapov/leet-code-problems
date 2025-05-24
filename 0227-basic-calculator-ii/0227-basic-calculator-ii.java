class Solution {
    public int calculate(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int result = 0;
        int prevNumber = 0;
        int currNumber = 0;
        char operation = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currNumber = currNumber * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || (i == s.length() - 1)) {
                switch (operation) {
                    case '+' -> {
                        result += prevNumber;
                        prevNumber = currNumber;
                    }
                    case '-' -> {
                        result += prevNumber;
                        prevNumber = -currNumber;
                    }
                    case '*' -> prevNumber *= currNumber;
                    case '/' -> prevNumber /= currNumber;
                    default -> throw new RuntimeException("Invalid operation: " + operation);
                }
                operation = c;
                currNumber = 0;
            }
        }
        return result + prevNumber;        
    }
}