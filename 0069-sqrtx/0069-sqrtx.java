class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        return search(x, 1, x);
    }

    private int search(int x, int l, int r) {
        if (l > r) return r;

        int m = l + ((r - l) / 2);

        long ms = (long) m * m;

        if (ms <= x && (long)(m + 1) * (m + 1) > x) return m;
        if (ms > x) return search(x, l, m - 1);
        else return search(x, m + 1, r);
    }
}