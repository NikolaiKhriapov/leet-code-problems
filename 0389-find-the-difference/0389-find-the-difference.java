class Solution {
    public char findTheDifference(String s, String t) {
        int[] array = new int[26];

        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            if (--array[c - 'a'] < 0) {
                return c;
            }
        }
        
        return '0';
    }
}