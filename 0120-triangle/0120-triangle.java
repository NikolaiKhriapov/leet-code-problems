class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            throw new IllegalArgumentException("Invalid input");
        } 

        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        int[] dp = new int[lastRow.size()];
        for (int i = 0; i < lastRow.size(); i++) {
            dp[i] = lastRow.get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[j] = row.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}

//   2  ~  ~  ~
//   3  4  ~  ~
//   6  5  7  ~
//   4  1  8  3

//  15 11  ~  ~
