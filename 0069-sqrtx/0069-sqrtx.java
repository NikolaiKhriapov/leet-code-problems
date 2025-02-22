class Solution {
    public int mySqrt(int x) {
        return helper(x, 0, x);
    }

    private int helper(int x, int l, int r) {
        if (l > r) return r;

        int m = l + (r - l) / 2;

        long n = (long) m * m;
        if (n == x) return m;
        if (n > x) return helper(x, l, m - 1);
        else return helper(x, m + 1, r);
    }
}