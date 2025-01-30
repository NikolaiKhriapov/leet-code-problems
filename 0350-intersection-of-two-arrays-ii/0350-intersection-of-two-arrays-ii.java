class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            int val = map.getOrDefault(n, 0);
            if (val > 0) {
                list.add(n);
                val--;
            }
            if (val == 0) {
                map.remove(n);
            } else {
                map.put(n, val);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}