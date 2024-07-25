class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        boolean[] set = new boolean[1001];
        for (int n : nums1) {
            set[n] = true;
        }

        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            if (set[n]) {
                list.add(n);
                set[n] = false;
            }
        }
        
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}