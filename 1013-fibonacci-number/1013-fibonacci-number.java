class Solution {
    public int fib(int n) {
        return fib(n, new int[31]);
    }

    private int fib(int n, int[] map) {
        if (n == 0 || n == 1) return n;

        if (map[n] != 0) return map[n];

        int result = fib(n - 1, map) + fib(n - 2, map);
        map[n] = result;
        return result;
    }
}