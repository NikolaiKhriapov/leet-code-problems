class Solution {
    public String decodeString(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Stack<String> stack = new Stack<>();
        int currNumber = 0;
        StringBuilder currString = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                currNumber = currNumber * 10 + (ch - '0');
            } else if (Character.isLetter(ch)) {
                currString.append(ch);
            } else if (ch == '[') {
                stack.add(currString.toString());
                stack.add(String.valueOf(currNumber));
                currNumber = 0;
                currString = new StringBuilder();
            } else if (ch == ']') {
                int prevNumber = Integer.parseInt(stack.pop());
                StringBuilder prevString = new StringBuilder(stack.pop());
                for (int i = 0; i < prevNumber; i++) {
                    prevString.append(currString);
                }
                currString = prevString;
                currNumber = 0;
            }
        }
        
        return currString.toString();
    }
}