class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] map = new int[1001];

        for (int n : nums1) {
            map[n]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            int v = map[n];
            if (v > 0) {
                list.add(n);
                map[n]--;
            }
        }
        
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}