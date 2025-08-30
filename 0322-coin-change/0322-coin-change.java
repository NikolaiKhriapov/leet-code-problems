class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Arrays.sort(coins);

        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (coin > i) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] != (amount + 1) ? dp[amount] : -1;
    }
}

// time  - O(n * m + m log(m))
// space - O(n)