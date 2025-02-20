class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] array = new boolean[1001];

        for (int n : nums1) {
            array[n] = true;
        }

        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            if (array[n]) {
                list.add(n);
                array[n] = false;
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}