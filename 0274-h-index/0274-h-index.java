class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] citationsCount = new int[citations.length + 1];
        for (int citation : citations) {
            if (citation > citations.length) {
                citationsCount[citations.length]++;
            } else {
                citationsCount[citation]++;
            }
        }
        
        int currSum = 0;
        for (int i = citationsCount.length - 1; i >= 1; i--) {
            currSum += citationsCount[i];
            if (currSum >= i) {
                return i;
            }
        }
        return 0;
    }
}

// [3,0,6,1,5]
// [0,1,2,3,4,5]
// [1,1,0,1,0,2]
// [1,1,0,3,2,2]