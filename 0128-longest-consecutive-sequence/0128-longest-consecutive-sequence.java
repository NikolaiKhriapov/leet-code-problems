class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int seqLongest = 1;
        for (int n : set) {
            int numCurr = n;
            int seqCurr = 1;
            
            if (set.contains(numCurr - 1)) {
                continue;
            }
            while (set.contains(numCurr + 1)) {
                seqCurr++;
                numCurr++;
            }
            seqLongest = Math.max(seqLongest, seqCurr);
        }
        
        return seqLongest;
    }
}
