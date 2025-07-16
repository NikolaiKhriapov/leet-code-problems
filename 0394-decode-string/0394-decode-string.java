class Solution {
    public String decodeString(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Deque<Pair> stack = new ArrayDeque<>();
        int currNumber = 0;
        StringBuilder currString = new StringBuilder();
        
        for (char currChar : s.toCharArray()) {
            if (Character.isDigit(currChar)) {
                currNumber = currNumber * 10 + (currChar - '0');
            } else if (Character.isLetter(currChar)) {
                currString.append(currChar);
            } else if (currChar == '[') {
                stack.push(new Pair(currNumber, currString));
                currNumber = 0;
                currString = new StringBuilder();
            } else if (currChar == ']') {
                Pair prev = stack.pop();
                for (int i = 0; i < prev.number; i++) {
                    prev.string.append(currString);
                }
                currNumber = 0;
                currString = prev.string;
            }
        }

        return currString.toString();
    }

    private record Pair(
        int number,
        StringBuilder string
    ) {
    }
}