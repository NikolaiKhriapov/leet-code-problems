class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (map.containsKey(sChar)) {
                if (map.get(sChar) != tChar) {
                    return false;
                }
            } else {
                if (set.contains(tChar)) {
                    return false;
                }
                map.put(sChar, tChar);
                set.add(tChar);
            }
        }
        return true;
    }
}

// time  - O(n)
// space - O(n)
