class Solution {
    public int longestSubstring(String s, int k) {
        return longestSubstring(s, 0, s.length(), k);
    }

    private static int longestSubstring(String s, int left, int right, int k) {
        if (s == null || right - left < k || k < 1) {
            return 0;
        }

        int[] map = new int[26];
        for (int i = left; i < right; i++) {
            char c = s.charAt(i);
            map[c - 'a']++;
        }
        
        for (int i = left; i < right; i++) {
            int charCount = map[s.charAt(i) - 'a'];
            if (charCount < k) {
                int l = longestSubstring(s, left, i, k);
                int r = (i + 1 < right)
                    ? longestSubstring(s, i + 1, right, k)
                    : 0;
                return Math.max(l, r);
            }
        }

        return right - left;
    }
}