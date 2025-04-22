class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k || k < 1) {
            return 0;
        }
        return longestSubstring(s, 0, s.length(), k);
    }

    private static int longestSubstring(String s, int left, int right, int k) {
        if (right - left < k) {
            return 0;
        }

        int[] count = new int[26];
        for (int i = left; i < right; i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        for (int i = left; i < right; i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                return Math.max(
                    longestSubstring(s, left, i, k),
                    longestSubstring(s, i + 1, right, k)
                );
            }
        }

        return right - left;
    }
}