class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (word1.isEmpty()) {
            return word2.length();
        }
        if (word2.isEmpty()) {
            return word1.length();
        }

        int length1 = word1.length();
        int length2 = word2.length();

        int[] prev = new int[length2 + 1];
        int[] curr = new int[length2 + 1];

        for (int c = 1; c <= length2; c++) {
            prev[c] = c;
        }

        for (int r = 1; r <= length1; r++) {
            curr[0] = r;
            for (int c = 1; c <= length2; c++) {
                if (word1.charAt(r - 1) == word2.charAt(c - 1)) {
                    curr[c] = prev[c - 1];
                } else {
                    curr[c] = 1 + Math.min(prev[c - 1], Math.min(prev[c], curr[c - 1]));
                }
            }
            prev = Arrays.copyOf(curr, curr.length);
        }

        return curr[length2];
    }
}

// time  - O(n * m)
// space - O(m + n)