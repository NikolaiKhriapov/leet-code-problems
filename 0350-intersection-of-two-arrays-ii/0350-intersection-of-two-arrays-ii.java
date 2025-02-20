class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int[] array = new int[1001];

        for (int n : nums1) {
            array[n]++;
        }

        for (int n : nums2) {
            if (array[n]-- > 0) {
                list.add(n);
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}