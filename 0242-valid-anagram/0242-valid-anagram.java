class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            if (count[c - 'a']-- <= 0) {
                return false;
            }
        }

        for (int n : count) {
            if (n != 0) {
                return false;
            }
        }

        return true;
    }
}