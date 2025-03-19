class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (n > 1) {
            n = helper(n);
            if (visited.add(n) == false) return false;
        }
        return n == 1;
    }

    private int helper(int n) {
        int result = 0;
        while (n > 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        return result;
    }
}