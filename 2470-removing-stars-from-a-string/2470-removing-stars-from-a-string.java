class Solution {
    public String removeStars(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                deque.pollLast();
            } else {
                deque.offerLast(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        return sb.toString();
    }
}