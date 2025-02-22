/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        
        while (l < r) {  // Stop when l == r
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m;  // Narrow to left side
            } else {
                l = m + 1;  // Move right
            }
        }
        return l;  // l and r are the same at the first bad version
    }
}