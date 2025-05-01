class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        return longestSubstring(s, k, 0, s.length());
    }

    private int longestSubstring(String s, int k, int left, int right) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = left; i < right; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int currentLongest = 0;
        int start = left;
        boolean isCurrentValid = true;
        for (int i = left; i < right; i++) {
            if (map.get(s.charAt(i)) < k) {
                if (i > start) {
                    currentLongest = Math.max(currentLongest, longestSubstring(s, k, start, i));
                }
                start = i + 1;
                isCurrentValid = false;
            }
        }

        if (isCurrentValid) {
            return right - left;
        }

        if (start < right) {
            currentLongest = Math.max(currentLongest, longestSubstring(s, k, start, right));
        }

        return currentLongest;
    }
}