class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int longestConsecutive = 0;

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        Set<Integer> visited = new HashSet<>();
        for (int n : set) {
            if (visited.contains(n)) {
                continue;
            }
            int consecutiveCount = 1;
            while (set.contains(++n)) {
                consecutiveCount++;
                visited.add(n);
            }
            longestConsecutive = Math.max(longestConsecutive, consecutiveCount);
        }
        
        return longestConsecutive;
    }
}

// time  - O(n)
// space - O(n)