/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        return search(n, 0, n);

    }

    private int search(int n, int l, int r) {
        if (r < l) return r;

        int m = l + ((r - l) / 2);
        boolean isMBad = isBadVersion(m);
        if (isMBad && !isBadVersion(m - 1)) return m;
        if (isMBad) return search(n, l, m - 1);
        else return search(n, m + 1, r);
    }
}