class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        List<Integer> perfectSquares = getPerfectSquares(n);

        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int square : perfectSquares) {
                if (i >= square) {
                    dp[i] = Math.min(dp[i], dp[i - square] + 1);
                }
            }
        }

        return dp[n];
    }

    private List<Integer> getPerfectSquares(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            result.add(i * i);
        }
        return result;
    }
}
