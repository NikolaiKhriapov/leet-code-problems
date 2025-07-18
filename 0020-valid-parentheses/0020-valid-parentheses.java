class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || map.get(stack.peek()) != c) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

// time  - O(n)
// space - O(n)