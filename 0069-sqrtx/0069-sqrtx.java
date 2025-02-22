class Solution {
    public int mySqrt(int x) {
        return (int) helper(x, 0, x);
    }

    private long helper(long x, long l, long r) {
        if (l > r) return r;

        long m = l + (r - l) / 2;

        if (m * m == x) return m;
        if (m * m > x) return helper(x, l, m - 1);
        if (m * m < x) return helper(x, m + 1, r);

        return -1;
    }
}