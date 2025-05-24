class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || amount < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount + 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (coin > i) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}

// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11]
// [0,12,12,12,12,12,12,12,12,12,12,12]
// [0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 3]