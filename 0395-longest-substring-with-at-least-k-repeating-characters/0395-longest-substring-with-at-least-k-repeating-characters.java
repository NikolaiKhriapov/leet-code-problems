class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k || k < 1) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (map.getOrDefault(s.charAt(i), 0) < k) {
                int left = longestSubstring(s.substring(0, i), k);

                int right = 0;
                if (i + 1 < s.length()) {
                    right = longestSubstring(s.substring(i + 1, s.length()), k);
                }
                return Math.max(left, right);
            }
        }
        

        return s.length();
    }
}