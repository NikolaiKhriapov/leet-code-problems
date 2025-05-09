class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for (int r = 0; r < dp.length; r++) {
            for (int c = 0; c < dp[0].length; c++) {
                if (r > 0 && dp[r - 1][c] && s1.charAt(r - 1) == s3.charAt(r + c - 1)) {
                    dp[r][c] = true;
                }
                if (c > 0 && dp[r][c - 1] && s2.charAt(c - 1) == s3.charAt(r + c - 1)) {
                    dp[r][c] = true;
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}

//      d b b c a
//   [+ - - - - -]
// a [+ - - - - -]
// a [+ + + + + -]
// b [- + + - + -]
// c [- - + + + +]
// c [- - - + - +]

// a a d b b c b c a c

//      d b b c a
//   [+ - - - - -]
// a [+ - - - - -]
// a [+ + + + - -]
// b [- + + + - -]
// c [- - - - - -]
// c [- - - - - -]

// a a d b b b a c c c
