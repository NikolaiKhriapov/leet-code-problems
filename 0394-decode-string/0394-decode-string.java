class Solution {
    public String decodeString(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Stack<Integer> stackNum = new Stack<>();
        Stack<StringBuilder> stackStr = new Stack<>();
        int currNumber = 0;
        StringBuilder currString = new StringBuilder();

        for (char currChar : s.toCharArray()) {
            if (Character.isDigit(currChar)) {
                currNumber = currNumber * 10 + (currChar - '0');
            } else if (Character.isLetter(currChar)) {
                currString.append(currChar);
            } else if (currChar == '[') {
                stackStr.add(currString);
                stackNum.add(currNumber);
                currString = new StringBuilder();
                currNumber = 0;
            } else if (currChar == ']') {
                int prevNumber = stackNum.pop();
                StringBuilder prevString = stackStr.pop();
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