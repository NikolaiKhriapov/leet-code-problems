class Solution {
    public int tribonacci(int n) {
        return tribonacci(n, new HashMap<>());
    }

    public int tribonacci(int n, Map<Integer, Integer> memo) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int res = tribonacci(n - 3, memo) + tribonacci(n - 2, memo) + tribonacci(n - 1, memo);
        memo.put(n, res);
        return res;
    }
}