class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = nums1.length;
        while (left <= right) {
            int p1 = (left + right) / 2;
            int p2 = (nums1.length + nums2.length + 1) / 2 - p1;

            int maxLeft1 = (p1 == 0) ? Integer.MIN_VALUE : nums1[p1 - 1];
            int minRight1 = (p1 == nums1.length) ? Integer.MAX_VALUE : nums1[p1];

            int maxLeft2 = (p2 == 0) ? Integer.MIN_VALUE : nums2[p2 - 1];
            int minRight2 = (p2 == nums2.length) ? Integer.MAX_VALUE : nums2[p2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 < minRight2) {
                left = p1 + 1;
            } else {
                right = p1 - 1;
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}

// [1,2,3,4,5,6,7,8,9], [5,6,7,8,9]
//          -                  -