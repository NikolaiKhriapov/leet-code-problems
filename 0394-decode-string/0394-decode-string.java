class Solution {
    public String decodeString(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (s.isEmpty()) {
            return "";
        }

        Deque<Integer> stackInt = new ArrayDeque<>();
        Deque<String> stackStr = new ArrayDeque<>();
        int currNumber = 0;
        StringBuilder currString = new StringBuilder();
        
        for (char currChar : s.toCharArray()) {
            if (Character.isDigit(currChar)) {
                currNumber = currNumber * 10 + (currChar - '0');
            } else if (Character.isLetter(currChar)) {
                currString.append(currChar);
            } else if (currChar == '[') {
                stackInt.push(currNumber);
                stackStr.push(currString.toString());
                currNumber = 0;
                currString = new StringBuilder();
            } else if (currChar == ']') {
                StringBuilder prevString = new StringBuilder(stackStr.pop());
                int prevNumber = stackInt.pop();
                for (int i = 0; i < prevNumber; i++) {
                    prevString.append(currString);
                }
                currNumber = 0;
                currString = prevString;
            }
        }

        return currString.toString();
    }
}