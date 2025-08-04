class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set1 = arrayToSet(nums1);
        Set<Integer> set2 = arrayToSet(nums2);
        addDifferenceToResult(set2, set1, result);
        addDifferenceToResult(set1, set2, result);
        return result;        
    }

    private static Set<Integer> arrayToSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        return set;
    }

    private static void addDifferenceToResult(Set<Integer> set1, Set<Integer> set2, List<List<Integer>> result) {
        List<Integer> list = new ArrayList<>();
        for (int n : set2) {
            if (!set1.contains(n)) {
                list.add(n);
            }
        }
        result.add(list);
    }
}

// time  - O(n + m)
// space - O(n + m)