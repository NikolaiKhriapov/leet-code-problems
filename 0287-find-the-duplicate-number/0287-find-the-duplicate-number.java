class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Invalid input");
        }

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return n;
            }
        }
        throw new IllegalArgumentException("Invalid input");
    }
}

// time  - O(n)
// space - O(1)