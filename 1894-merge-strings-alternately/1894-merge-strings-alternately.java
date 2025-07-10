class Solution {
    public String mergeAlternately(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        StringBuilder sb = new StringBuilder();
        
        int p = 0;
        while (p < word1.length() || p < word2.length()) {
            if (p < word1.length()) {
                sb.append(word1.charAt(p));
            }
            if (p < word2.length()) {
                sb.append(word2.charAt(p));
            }
            p++;
        }

        return sb.toString();        
    }
}