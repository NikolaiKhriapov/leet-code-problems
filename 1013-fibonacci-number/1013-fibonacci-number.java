class Solution {
    public int fib(int n) {
        return fib(n, new HashMap<>());
    }

    private int fib(int n, Map<Integer, Integer> map) {
        if (n == 0 || n == 1) return n;

        if (map.containsKey(n)) return map.get(n);

        int result = fib(n - 1, map) + fib(n - 2, map);
        map.put(n, result);
        return result;
    }
}