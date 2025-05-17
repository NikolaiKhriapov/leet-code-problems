class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[] dp = new boolean[s2.length() + 1];

        // first row
        dp[0] = true;
        for (int col = 1; col <= s2.length(); col++) {
            dp[col] = dp[col - 1] && s2.charAt(col - 1) == s3.charAt(col - 1);
        }

        // remaining rows
        for (int row = 1; row <= s1.length(); row++) {
            dp[0] = dp[0] && s1.charAt(row - 1) == s3.charAt(row - 1);
            for (int col = 1; col <= s2.length(); col++) {
                dp[col] = (dp[col] && s1.charAt(row - 1) == s3.charAt(row + col - 1))
                       || (dp[col - 1] && s2.charAt(col - 1) == s3.charAt(row + col - 1));
            }
        }

        return dp[s2.length()];        
    }
}

//      d b b c a
//   [+,-,-,-,-,-]
// a [+,-,-,-,-,-]
// a [+,+,+,+,+,-]
// b [-,+,+,-,+,-]
// c [-,-,+,+,+,+]
// c [-,-,-,+,-,+]

// a a d b b c b c a c