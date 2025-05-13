class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new IllegalArgumentException("Invalid state");
        }
        if (word1.isEmpty()) {
            return word2.length();
        }
        if (word2.isEmpty()) {
            return word1.length();
        }

        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int row = 0; row <= length1; row++) {
            dp[row][0] = row;
        }
        for (int col = 0; col <= length2; col++) {
            dp[0][col] = col;
        }
        for (int row = 1; row <= length1; row++) {
            for (int col = 1; col <= length2; col++) {
                if (word1.charAt(row - 1) == word2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    dp[row][col] = 1 + Math.min(dp[row - 1][col - 1], Math.min(dp[row - 1][col], dp[row][col - 1]));
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