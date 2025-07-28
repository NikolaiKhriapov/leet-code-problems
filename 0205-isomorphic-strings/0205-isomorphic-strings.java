class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (s.length() != t.length()) {
            return false;
        }

        char[] map = new char[256];
        boolean[] set = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (map[sChar] != 0) {
                if (map[sChar] != tChar) {
                    return false;
                }
            } else {
                if (set[tChar]) {
                    return false;
                }
                map[sChar] = tChar;
                set[tChar] = true;
            }
        }
        return true;
    }
}

// time  - O(n)
// space - O(1)
