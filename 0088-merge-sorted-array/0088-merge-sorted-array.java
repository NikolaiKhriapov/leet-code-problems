class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums2.length != n || nums1.length != m + n) {
            throw new IllegalArgumentException("Invalid input");
        }

        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p >= 0 && p1 < p) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
    }
}

// time  - O(n)
// space - O(1)