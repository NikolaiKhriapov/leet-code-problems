class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) {
            if (set.add(n));
        }

        Set<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            if (set.contains(n)) {
                set2.add(n);
            }
        }

        int[] result = new int[set2.size()];
        int i = 0;
        for (int n : set2) {
            result[i] = n;
            i++;
        }

        return result;
    }
}