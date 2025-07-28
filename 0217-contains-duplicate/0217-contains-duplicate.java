class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}

// time. - O(n)
// space - O(n)