class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Set<Integer> set1 = arrayToSet(nums1);
        Set<Integer> set2 = arrayToSet(nums2);

        List<Integer> list1 = getDistinctNums(set1, set2);
        List<Integer> list2 = getDistinctNums(set2, set1);

        return new ArrayList<>(List.of(list1, list2));
    }

    private Set<Integer> arrayToSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        return set;
    }

    private List<Integer> getDistinctNums(Set<Integer> set1, Set<Integer> set2) {
        List<Integer> list = new ArrayList<>();
        for (int n : set1) {
            if (!set2.contains(n)) {
                list.add(n);
            }
        }
        return list;
    }
}