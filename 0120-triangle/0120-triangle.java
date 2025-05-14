class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] dp = new int[triangle.size()];
        List<Integer> lastLevel = triangle.get(triangle.size() - 1);
        for (int i = 0; i < triangle.size(); i++) {
            dp[i] = lastLevel.get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> level = triangle.get(i);
            for (int j = 0; j < level.size(); j++) {
                dp[j] = level.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        
        return dp[0];
    }
}
