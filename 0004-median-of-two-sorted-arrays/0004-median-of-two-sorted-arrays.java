class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums = new int[nums1.length + nums2.length];

        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 < nums1.length || p2 < nums2.length) {
            if (p1 == nums1.length) {
                nums[p++] = nums2[p2++];
            } else if (p2 == nums2.length) {
                nums[p++] = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                nums[p++] = nums1[p1++];
            } else {
                nums[p++] = nums2[p2++];
            }
        }
        System.out.println(Arrays.toString(nums));

        if (nums.length % 2 != 0) {
            return nums[nums.length / 2];
        } else {
            return ((double) nums[nums.length / 2 - 1] + (double) nums[nums.length / 2]) / (double) 2;
        }
    }
}

// 1,2,3,4
// [2 2 2 4 5] [2 4]