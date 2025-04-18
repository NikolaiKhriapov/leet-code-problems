class Solution {
    private static final int INF = Integer.MAX_VALUE - 1;

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = INF;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > 0 && i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] == INF ? -1 : dp[amount];
    }
}
