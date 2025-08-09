class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[] dp = new boolean[s2.length() + 1];
        dp[0] = true;
        for (int c = 1; c <= s2.length(); c++) {
            dp[c] = dp[c - 1] && s2.charAt(c - 1) == s3.charAt(c - 1);
        }

        for (int r = 1; r <= s1.length(); r++) {
            dp[0] = dp[0] && s1.charAt(r - 1) == s3.charAt(r - 1);
            for (int c = 1; c <= s2.length(); c++) {
                dp[c] = (dp[c - 1] && s2.charAt(c - 1) == s3.charAt(r + c - 1)) ||
                        (dp[c] && s1.charAt(r - 1) == s3.charAt(r + c - 1));
            }
        }

        return dp[s2.length()];
    }
}

// time  - O(n + m)
// space - O(m)