class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || (s1.length() + s2.length() != s3.length())) {
            return false;
        }

        int rows = s1.length() + 1;
        int cols = s2.length() + 1;
        
        boolean[][] dp = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 && col == 0) {
                    dp[row][col] = true;
                    continue;
                }
                if (row > 0 && dp[row - 1][col] && s1.charAt(row - 1) == s3.charAt(row + col - 1)) {
                    dp[row][col] = true;
                }
                if (col > 0 && dp[row][col - 1] && s2.charAt(col - 1) == s3.charAt(row + col - 1)) {
                    dp[row][col] = true;
                }
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

// aadbbcbcac