class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        
        int next = 1;
        int nextNext = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curr;
            if (s.charAt(i) == '0') {
                curr = 0;
            } else {
                curr = next;
                if (i + 2 <= s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    curr += nextNext;
                }
            }
            nextNext = next;
            next = curr;
        }

        return next;
    }
}