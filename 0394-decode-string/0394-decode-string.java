class Solution {
    public String decodeString(String s) {

        Stack<Pair> stack = new Stack<>();
        int currNumber = 0;
        StringBuilder currString = new StringBuilder();

        for (char currChar : s.toCharArray()) {
            if (Character.isDigit(currChar)) {
                currNumber = currNumber * 10 + (currChar - '0');
            } else if (Character.isLetter(currChar)) {
                currString.append(currChar);
            } else if (currChar == '[') {
                stack.add(new Pair(currNumber, currString));
                currString = new StringBuilder();
                currNumber = 0;
            } else if (currChar == ']') {
                Pair pair = stack.pop();
                for (int i = 0; i < pair.prevNumber; i++) {
                    pair.prevString.append(currString);
                }
                currString = pair.prevString;
                currNumber = 0;
            }
        }        

        return currString.toString();
    }

    private class Pair {
        int prevNumber;
        StringBuilder prevString;

        Pair(int prevNumber, StringBuilder prevString) {
            this.prevNumber = prevNumber;
            this.prevString = prevString;
        }
    }
}