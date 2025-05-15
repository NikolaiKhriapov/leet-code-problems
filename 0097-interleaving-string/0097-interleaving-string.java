class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int rows = s1.length() + 1;
        int cols = s2.length() + 1;

        boolean[][] dp = new boolean[rows][cols];
        dp[0][0] = true;
        for (int row = 1; row < rows; row++) {
            if (dp[row - 1][0] && s1.charAt(row - 1) == s3.charAt(row - 1)) {
                dp[row][0] = true;
            }
        }
        for (int col = 1; col < cols; col++) {
            if (dp[0][col - 1] && s2.charAt(col - 1) == s3.charAt(col - 1)) {
                dp[0][col] = true;
            }
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (row == 0 && col == 0) {
                    dp[row][col] = true;
                    continue;
                }
                dp[row][col] = (dp[row - 1][col] && s1.charAt(row - 1) == s3.charAt(row + col - 1))
                            || (dp[row][col - 1] && s2.charAt(col - 1) == s3.charAt(row + col - 1));
            }
        }

        return dp[rows - 1][cols - 1];
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