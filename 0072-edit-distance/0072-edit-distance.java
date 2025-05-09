class Solution {
    public int minDistance(String word1, String word2) {

        int length1 = word1.length();
        int length2 = word2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int r = 0; r < dp.length; r++) {
            dp[r][0] = r;
        }
        for (int c = 0; c < dp[0].length; c++) {
            dp[0][c] = c;
        }

        for (int r = 1; r < dp.length; r++) {
            for (int c = 1; c < dp[0].length; c++) {
                if (word1.charAt(r - 1) == word2.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    dp[r][c] = 1 + Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1]));
                }
            }
        }

        return dp[length1][length2];
    }
}

//      r o s
//   [0,1,2,3]
// h [1,1,2,3]
// o [2,2,1,2]
// r [3,2,2,2]
// s [4,3,3,2]
// e [5,4,4,3]