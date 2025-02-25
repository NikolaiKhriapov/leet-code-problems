class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] array = new int[1001];

        for (int n : nums1) {
            array[n]++;
        }
        
        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            if (array[n] > 0) {
                array[n]--;
                list.add(n);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}