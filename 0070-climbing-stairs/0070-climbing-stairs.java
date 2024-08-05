class Solution {
    public int climbStairs(int n) {
        return climbStairs(n, new HashMap<>());
    }

    public int climbStairs(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) return 1;

        if (memo.containsKey(n)) return memo.get(n);

        int result = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        memo.put(n, result);
        return result;
    }
}