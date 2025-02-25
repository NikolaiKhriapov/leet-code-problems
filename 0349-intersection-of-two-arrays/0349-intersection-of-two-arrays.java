class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] arr = new boolean[1001];

        for (int n : nums1) {
            arr[n] = true;
        }

        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            if (arr[n]) {
                list.add(n);
                arr[n] = false;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}