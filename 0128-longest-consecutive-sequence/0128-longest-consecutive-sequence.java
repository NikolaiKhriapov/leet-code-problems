class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int seqLongest = 1;
        for (int n : nums) {
            int numCurr = n;
            int seqCurr = 1;
            
            if (!set.contains(numCurr) || set.contains(numCurr - 1)) {
                continue;
            }
            while (set.contains(numCurr + 1)) {
                seqCurr++;
                numCurr++;
                set.remove(numCurr);
            }
            seqLongest = Math.max(seqLongest, seqCurr);
        }
        
        return seqLongest;
    }
}
