class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] citationsCount = countCitations(citations);
        return getHIndex(citationsCount);
    }

    private int[] countCitations(int[] citations) {
        int[] result = new int[citations.length + 1];
        for (int citation : citations) {
            if (citation >= result.length) {
                result[result.length - 1]++;
            } else {
                result[citation]++;
            }
        }
        return result;
    }

    private int getHIndex(int[] citationsCount) {
        int count = 0;
        for (int i = citationsCount.length - 1; i >= 1; i--) {
            count += citationsCount[i];
            if (count >= i) {
                return i;
            }
        }
        return count;
    }
}