class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] citationCount = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > citations.length) {
                citations[i] = citations.length;
            }
            citationCount[citations[i]]++;
        }
        
        int cumulativeSum = 0;
        for (int i = citations.length; i >= 0; i--) {
            cumulativeSum += citationCount[i];
            if (cumulativeSum >= i) {
                return i;
            }
        }

        return 0;
    }
}

// time  - O(n)
// space - O(n)

//.  [3,0,6,1,5]
// [0,0,0,0,0,0]