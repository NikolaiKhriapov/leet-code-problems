class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        int pm = m - 1;
        int pn = n - 1;
        int p = nums1.length - 1;
        
        while (m > 0 && pm >= 0 && pn >= 0) {
            if (nums2[pn] >= nums1[pm]) {
                nums1[p] = nums2[pn];
                pn--;
            } else {
                nums1[p] = nums1[pm];
                pm--;
            }
            p--;
        }

        if (pn >= 0) {
            for (int i = p; i >= 0; i--) {
                nums1[p] = nums2[pn];
                pn--;
                p--;
            }
        }
    }
}