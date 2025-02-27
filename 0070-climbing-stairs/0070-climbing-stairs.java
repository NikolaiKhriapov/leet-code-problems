class Solution {
    public int climbStairs(int n) {
        return climbStairs(n, new HashMap<>());
    }

    private int climbStairs(int n, Map<Integer, Integer> map) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }
        
        int result = climbStairs(n - 1, map) + climbStairs(n - 2, map);
        map.put(n, result);
        return result;
    }
}