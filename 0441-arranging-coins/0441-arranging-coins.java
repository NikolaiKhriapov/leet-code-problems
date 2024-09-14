class Solution {
    public int arrangeCoins(int n) {
        return search(n, 0, n);
    }

    public int search(int n, int l, int r) {
        if (l > r) {
            return r;
        }

        int m = l + ((r - l) / 2);
        long ml = (long) m;

        long coinsForRowM = ml * (ml + 1) / 2;
        long coinsForRowMM = (ml + 1) * (ml + 2) / 2;

        if (n >= coinsForRowM && n < coinsForRowMM) {
            return m;
        }
        if (n > coinsForRowM) {
            return search(n, m + 1, r);
        } else {
            return search(n, l, m - 1);
        }
    }
}
