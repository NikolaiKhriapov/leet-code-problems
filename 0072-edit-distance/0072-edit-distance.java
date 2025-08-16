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

        int[] prev = new int[word2.length() + 1];
        int[] curr = new int[word2.length() + 1];
        
        for (int c = 1; c < prev.length; c++) {
            prev[c] = c;
        }

        for (int r = 1; r <= word1.length(); r++) {
            curr[0] = r;
            for (int c = 1; c <= word2.length(); c++) {
                if (word1.charAt(r - 1) == word2.charAt(c - 1)) {
                    curr[c] = prev[c - 1];
                } else {
                    curr[c] = 1 + Math.min(prev[c - 1], Math.min(prev[c], curr[c - 1]));
                }
            }
            int[] temp = curr;
            curr = prev;
            prev = temp;
        }
        
        return prev[word2.length()];
    }
}

// time  - O(n * m)
// space - O(n)