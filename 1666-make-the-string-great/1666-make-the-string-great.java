class Solution {
    public String makeGood(String s) {

        char[] arr = new char[s.length()];
        Stack<Character> stack = new Stack<>();

        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && ((stack.peek() == c - 32) || (stack.peek() == c + 32))) {
                stack.pop();
                idx--;
            } else {
                stack.push(c);
                arr[idx] = c;
                idx++;
            }
        }
        
        return new String(arr, 0, idx);
    }
}