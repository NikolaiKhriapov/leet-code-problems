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

        int longest = 0;
        for (int n : nums) {
            if (set.contains(n - 1)) {
                continue;
            }
            int currLongest = 0;
            while (set.contains(n)) {
                set.remove(n);
                currLongest++;
                n++;
            }
            longest = Math.max(longest, currLongest);
        }
        
        return longest;
    }
}