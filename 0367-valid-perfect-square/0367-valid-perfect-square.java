class Solution {
    public boolean isPerfectSquare(int num) {
        return search(num, 1, num) != -1;
    }

    private int search(int num, int l, int r) {
        if (r < l) {
            return -1;
        }

        int m = l + ((r - l) / 2);
        long ms = (long) m * m;
        
        if (ms == num) {
            return m;
        }
        if (ms > num) {
            return search(num, l, m - 1);
        } else {
            return search(num, m + 1, r);
        }
    }
}