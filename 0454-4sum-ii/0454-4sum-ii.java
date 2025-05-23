class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || nums3 == null || nums3.length == 0 || nums4 == null || nums4.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int sum = num3 + num4;
                if (map.containsKey(-sum)) {
                    count += map.get(-sum);
                }
            }
        }
        return count;       
    }
}