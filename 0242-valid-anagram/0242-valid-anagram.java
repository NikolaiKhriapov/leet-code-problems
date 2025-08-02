class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            int val = map.getOrDefault(c, 0);
            if (val <= 0) {
                return false;
            }
            map.put(c, val - 1);
        }
        return true;
    }
}

// time. - O(n)
// space - O(1)