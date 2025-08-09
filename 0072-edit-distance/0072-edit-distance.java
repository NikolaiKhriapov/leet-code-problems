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

//     i n t e n t i o n
//   0 1 2 3 4 5 6 7 8 9
// e 1 1 2 3 3 4 5 6 7 8
// x 2 2 2 3 4 4 5 6 7 8
// e 3 3 3 3 3 4 5 6 7 8
// c 4 4 4 4 4 4 5 6 7 8
// u 5 5 5 5 5 5 5 6 7 8
// t 6 6 6 5 6 6 5 6 7 8
// i 7 6 7 6 6 7 6 5 0 0
// o 8 0 0 0 0 0 0 0 5 0
// n 9 0 0 0 0 0 0 0 0 5