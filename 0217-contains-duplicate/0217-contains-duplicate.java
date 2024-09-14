class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            boolean isAdded = set.add(n);
            if (!isAdded) {
                return true;
            }
        }

        return false;
    }
}