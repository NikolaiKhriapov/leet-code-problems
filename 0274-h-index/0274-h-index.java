class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int[] count = countCitations(citations);
        return calculateHIndex(count);
    }

    private int[] countCitations(int[] citations) {
        int[] count = new int[citations.length + 1];
        for (int citation : citations) {
            if (citation > citations.length) {
                count[count.length - 1]++;
            } else {
                count[citation]++;
            }
        }
        return count;
    }

    private int calculateHIndex(int[] count) {
        int total = 0;
        for (int i = count.length - 1; i > 0; i--) {
            total += count[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }
}

// [3,0,6,1,5]

// [0,1,2,3,4,5]
// [1,1,0,1,0,2]
// [5,4,3,3,2,2]
