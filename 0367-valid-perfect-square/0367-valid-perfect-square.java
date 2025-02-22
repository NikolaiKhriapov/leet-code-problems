class Solution {
    public boolean isPerfectSquare(int num) {
        return helper(num, 1, num);
    }

    private boolean helper(int num, int l, int r) {
        if (r < l) return false;

        int m = l + (r - l) / 2;
        long ms = (long) m * m;

        if (ms == num) return true;
        if (ms > num) return helper(num, l, m - 1);
        return helper(num, m + 1, r);
    }
}