/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return helper(1, n);
    }

    private int helper(int l, int r) {
        if (l > r) return l;

        int m = l + (r - l) / 2;

        if (isBadVersion(m)) {
            return helper(l, m - 1);
        } else {
            return helper(m + 1, r);
        }
    }
}