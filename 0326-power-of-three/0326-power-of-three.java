class Solution {
    public boolean isPowerOfThree(int n) {
        for (long i = 1; i <= n; i++) {
            long x = i;
            while (x < n && x != n) {
                x *= 3;
            }
            if (x == n) return true;
            if (x > n) return false;
        }
        
        return false;
    }
}