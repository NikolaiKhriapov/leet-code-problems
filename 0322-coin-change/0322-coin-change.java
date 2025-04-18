class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }

        return coinChange(coins, amount, new HashMap<>());
    }

    private void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    private static int coinChange(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        }
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin, memo);
            if (res >= 0) {
                minCoins = Math.min(minCoins, 1 + res);
            }
        }

        int result = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        memo.put(amount, result);
        return result;
    }
}