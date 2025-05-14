class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || (s1.length() + s2.length() != s3.length())) {
            return false;
        }

        int rows = s1.length() + 1;
        int cols = s2.length() + 1;
        boolean[] dp = new boolean[cols];
        
        dp[0] = true;
        for (int col = 1; col < cols; col++) {
            dp[col] = dp[col - 1] && s2.charAt(col - 1) == s3.charAt(col - 1);
        }
        for (int row = 1; row < rows; row++) {
            dp[0] = dp[0] && s1.charAt(row - 1) == s3.charAt(row - 1);
            for (int col = 1; col < cols; col++) {
                dp[col] = (dp[col] && s1.charAt(row - 1) == s3.charAt(row + col - 1))
                       || (dp[col - 1] && s2.charAt(col - 1) == s3.charAt(row + col - 1));
            }
        }
        
        return dp[cols - 1];
    }
}

//      d b b c a
//   [+,-,-,-,-,-]
// a [+,-,-,-,-,-]
// a [+,+,+,+,+,-]
// b [-,+,+,-,+,-]
// c [-,-,+,+,+,+]
// c [-,-,-,+,-,+]

// aadbbcbcac