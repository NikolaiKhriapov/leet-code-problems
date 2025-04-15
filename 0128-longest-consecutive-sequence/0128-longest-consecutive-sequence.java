class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        
        int seqLongest = 0;
        for (int n : nums) {
            if (!set.contains(n)) {
                continue;
            }
            if (!set.contains(n - 1)) {
                int seqCurrent = 1;
                int currentNum = n;
                while (set.contains(currentNum + 1)) {
                    seqCurrent++;
                    currentNum++;
                    set.remove(currentNum);
                }
                seqLongest = Math.max(seqLongest, seqCurrent);
            }
        }

        return seqLongest;
    }
}
