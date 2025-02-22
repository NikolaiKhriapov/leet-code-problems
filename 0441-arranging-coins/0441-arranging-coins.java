class Solution {
    public int arrangeCoins(int n) {
        return helper(n, 0, n);
    }

    private int helper(int n, int l, int r) {
        if (l > r) return r;

        int m = l + (r - l) / 2;
        long mExp = (long) m * ((long) m + 1) / 2;

        if (n == mExp) return m;
        if (n > mExp) return helper(n, m + 1, r);
        return helper(n, l, m - 1);
    }
}