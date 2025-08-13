class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[] prev = new boolean[s2.length() + 1];
        boolean[] curr = new boolean[s2.length() + 1];
        
        for (int r = 0; r <= s1.length(); r++) {
            for (int c = 0; c <= s2.length(); c++) {
                if (r == 0 && c == 0) {
                    curr[c] = true;
                    continue;
                }
                curr[c] = (r > 0 && prev[c] && s1.charAt(r - 1) == s3.charAt(r + c - 1)) ||
                          (c > 0 && curr[c - 1] && s2.charAt(c - 1) == s3.charAt(r + c - 1));
            }
            boolean[] temp = curr;
            curr = prev;
            prev = temp;
        }

        return prev[s2.length()];
    }
}

// time  - O(n*m)
// space - O(m)