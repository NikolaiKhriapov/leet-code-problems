class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n : nums1) {
            set.add(n);
        }

        for (int n : nums2) {
            if (set.contains(n)) {
                set2.add(n);
                set.remove(n);
            }
        }
        
        int[] result = new int[set2.size()];
        int p = 0;
        for (int n : set2) {
            result[p++] = n;
        }

        return result;
    }
}