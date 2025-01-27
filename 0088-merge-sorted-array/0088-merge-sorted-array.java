class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = nums1.length - 1;
        int l = m - 1;
        int r = n - 1;

        while (l >= 0 && r >= 0) {
            if (nums2[r] >= nums1[l]) {
                nums1[p] = nums2[r];
                r--;
            } else {
                nums1[p] = nums1[l];
                l--;
            }
            p--;
        }

        if (r >= 0) {
            for (int i = r; i >= 0; i--) {
                nums1[i] = nums2[i];
            }
        }
    }
}