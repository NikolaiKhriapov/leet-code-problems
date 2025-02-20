class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (!map.containsKey(cs)) {
                if (!map.containsValue(ct)) {
                    map.put(cs, ct);
                } else {
                    return false;
                }
            } else {
                if (map.get(cs) != ct) {
                    return false;
                }
            }
        }
        
        return true;
    }
}