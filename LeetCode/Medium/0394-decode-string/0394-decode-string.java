class Solution {
    public String decodeString(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Deque<Pair> stack = new ArrayDeque<>();
        int currNumber = 0;
        StringBuilder currString = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currNumber = currNumber * 10 + (c - '0');
            } else if (Character.isLetter(c)) {
                currString.append(c);
            } else if (c == '[') {
                stack.push(new Pair(currNumber, currString));
                currNumber = 0;
                currString = new StringBuilder();
            } else if (c == ']') {
                Pair prev = stack.pop();
                for (int i = 0; i < prev.number; i++) {
                    prev.string.append(currString);
                }
                currString = prev.string;
            }
        }
        
        return currString.toString();
    }

    static class Pair {
        int number;
        StringBuilder string;

        Pair(int number, StringBuilder string) {
            this.number = number;
            this.string = string;
        }
    }
}

// time  - O(n)
// space - O(n)