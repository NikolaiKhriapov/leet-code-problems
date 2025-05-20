class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int result = 0;
        int currNumber = 0;
        int lastNumber = 0;
        char operation = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currNumber = currNumber * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch (operation) {
                    case '+' -> {
                        result += lastNumber;
                        lastNumber = currNumber;
                    }
                    case '-' -> {
                        result += lastNumber;
                        lastNumber = -currNumber;
                    }
                    case '*' -> lastNumber *= currNumber;
                    case '/' -> lastNumber /= currNumber;
                }
                operation = c;
                currNumber = 0;
            }
        }

        return result + lastNumber;
    }
}