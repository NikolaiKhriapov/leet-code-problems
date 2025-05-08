class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (nums.length <= 1) {
            return nums.length;
        }

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int longestCount = 0;
        for (int n : set) {
            if (set.contains(n - 1)) {
                continue;
            }
            int count = 0;
            while (set.contains(n + count)) {
                // set.remove(n + count);
                count++;
            }
            longestCount = Math.max(longestCount, count);
        }
        
        return longestCount;
    }
}