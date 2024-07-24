class Solution {
    public char findTheDifference(String s, String t) {

        int[] letterCount = new int[26];

        for (char c : s.toCharArray()) {
            letterCount[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            if (--letterCount[c - 'a'] < 0) return c;
        }
        
        return '0';
    }
}