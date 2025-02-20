class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] array = new int[1001];

        for (int n : nums1) {
            array[n]++;
        }

        Set<Integer> set = new HashSet<>();
        for (int n : nums2) {
            if (array[n] > 0) {
                set.add(n);
            }
        }
        
        int[] result = new int[set.size()];
        int p = 0;
        for (int n : set) {
            result[p++] = n;
        }

        return result;
    }
}