class Solution {
    public int numDecodings(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (s.isEmpty() || s.startsWith("0")) {
            return 0;
        }

        int nextPrev = 0;
        int prev = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = s.charAt(i) - '0';
            int curr = 0;
            if (digit > 0) {
                curr += prev;
                if (i < s.length() - 1 && (digit == 1 || digit == 2) && (digit * 10 + (s.charAt(i + 1) - '0')) <= 26) {
                    curr += nextPrev;
                }
            }
            nextPrev = prev;
            prev = curr;
        }
        return prev;
    }
}

// time  - O(n)
// space - O(1)
