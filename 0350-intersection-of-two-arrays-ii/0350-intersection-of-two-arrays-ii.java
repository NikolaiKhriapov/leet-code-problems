class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        int[] arr = new int[1001];
        for (int n : nums1) {
            arr[n]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            if (arr[n] > 0) {
                list.add(n);
                arr[n]--;
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}