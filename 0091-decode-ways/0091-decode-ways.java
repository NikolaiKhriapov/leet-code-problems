class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.startsWith("0")) {
            return 0;
        }

        int nextNext = 0;
        int next = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = 0;
            if (s.charAt(i) != '0') {
                curr = next;
                if (i < s.length() - 1 && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    curr += nextNext;
                }
            }
            nextNext = next;
            next = curr;
        }
        
        return next;
    }
}