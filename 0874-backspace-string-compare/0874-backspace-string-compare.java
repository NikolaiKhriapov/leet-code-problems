class Solution {
    public boolean backspaceCompare(String s, String t) {

        Stack<Character> stackS = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stackS.isEmpty()) {
                    stackS.pop();
                }
            } else {
                stackS.add(c);
            }
        }

        Stack<Character> stackT = new Stack<>();
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!stackT.isEmpty()) {
                    stackT.pop();
                }
            } else {
                stackT.add(c);
            }
        }

        if (stackS.size() != stackT.size()) {
            return false;
        }
        while (!stackS.isEmpty()) {
            if (stackS.pop() != stackT.pop()) {
                return false;
            }
        }
        return true;
    }
}