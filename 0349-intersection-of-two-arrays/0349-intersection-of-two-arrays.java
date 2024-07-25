class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }

        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            if (set.contains(n)) {
                list.add(n);
                set.remove(n);
            }
        }
        
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}