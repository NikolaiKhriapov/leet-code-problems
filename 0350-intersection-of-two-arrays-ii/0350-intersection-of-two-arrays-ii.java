class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Integer, Integer> map = getFrequencyMap(nums1);
        List<Integer> list = getIntersectingElements(map, nums2);
        return listToArray(list);
    }

    private Map<Integer, Integer> getFrequencyMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    private List<Integer> getIntersectingElements(Map<Integer, Integer> map, int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            int val = map.getOrDefault(num, 0);
            if (val > 0) {
                list.add(num);
                map.put(num, val - 1);
            }
        }
        return list;
    }

    private int[] listToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

// time. - O(n + m)
// space - O(min(m, n))