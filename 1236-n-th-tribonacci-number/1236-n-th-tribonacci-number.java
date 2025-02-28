class Solution {
    public int tribonacci(int n) {
        return tribonacci(n, new HashMap<>());
    }

    public int tribonacci(int n, Map<Integer, Integer> map) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        if (map.containsKey(n)) return map.get(n);

        int result = tribonacci(n - 1, map) + tribonacci(n - 2, map) + tribonacci(n - 3, map);
        map.put(n, result);
        return result;
    }
}