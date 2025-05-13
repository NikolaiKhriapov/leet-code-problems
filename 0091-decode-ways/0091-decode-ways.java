class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.startsWith("0")) {
            return 0;
        }

        int length = s.length();
        int nextPrev = 0;
        int prev = 1;
        for (int i = length - 1; i >= 0; i--) {
            int curr = 0;
            if (s.charAt(i) != '0') {
                curr = prev;
                if (i < length - 1 && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    curr += nextPrev;
                }
            }
            nextPrev = prev;
            prev = curr;
        }
        return prev;
    }
}
