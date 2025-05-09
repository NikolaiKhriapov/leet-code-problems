class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int rows = s1.length();
        int cols = s2.length();

        boolean[] dp = new boolean[cols + 1];
        dp[0] = true;

        for (int c = 1; c <= cols; c++) {
            dp[c] = dp[c - 1] && s2.charAt(c - 1) == s3.charAt(c - 1);
        }
        
        for (int r = 1; r <= rows; r++) {
            dp[0] = dp[0] && s1.charAt(r - 1) == s3.charAt(r - 1);
            for (int c = 1; c <= cols; c++) {
                dp[c] = (dp[c] && s1.charAt(r - 1) == s3.charAt(r + c - 1)) ||
                        (dp[c - 1] && s2.charAt(c - 1) == s3.charAt(r + c - 1));
            }
        }

        return dp[cols];
    }
}

//      d b b c a
//   [+,-,-,-,-,-]
// a [+,-,-,-,-,-]
// a [+,+,+,+,+,-]
// b [-,+,+,-,+,-]
// c [-,-,+,+,+,+]
// c [-,-,-,+,-,+]
//
// a a d b b c b c a c