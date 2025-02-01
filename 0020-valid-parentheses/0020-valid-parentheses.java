class Solution {
    public boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.size() > 0 && stack.peek() == map.get(c)) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        
        return stack.size() == 0;
    }
}
