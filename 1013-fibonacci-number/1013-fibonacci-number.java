class Solution {
    public int fib(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);

        return fib(n, map);
    }

    private int fib(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int fibN = fib(n - 1) + fib(n - 2);
        map.put(n, fibN);
        return fibN;
    }
}