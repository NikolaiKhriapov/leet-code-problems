class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || (nums1.length == 0 && nums2.length == 0)) {
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

            int leftMax1 = (p1 == 0) ? Integer.MIN_VALUE : nums1[p1 - 1];
            int rightMin1 = (p1 == nums1.length) ? Integer.MAX_VALUE : nums1[p1];
            
            int leftMax2 = (p2 == 0) ? Integer.MIN_VALUE : nums2[p2 - 1];
            int rightMin2 = (p2 == nums2.length) ? Integer.MAX_VALUE : nums2[p2];

            if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0;
                }
                return Math.max(leftMax1, leftMax2);
            } else if (leftMax1 > rightMin2) {
                right = p1 - 1;
            } else {
                left = p1 + 1;
            }
        }

        throw new IllegalArgumentException("Invalid input: one of input arrays is not sorted");
    }
}

// [1,2,3,4,5,6,7,8,9], [5,6,7,8,9]
//          -                  -