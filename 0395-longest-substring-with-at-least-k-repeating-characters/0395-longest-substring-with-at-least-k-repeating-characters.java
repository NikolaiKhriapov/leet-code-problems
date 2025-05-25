class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || k < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        return longestSubstring(s, k, 0, s.length());
    }

    private int longestSubstring(String s, int k, int left, int right) {
        if (right - left < k) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = left; i < right; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean isGood = true;
        int start = left;
        int currentLongest = 0;
        for (int i = left; i < right; i++) {
            char c = s.charAt(i);
            if (map.get(c) < k) {
                isGood = false;
                currentLongest = Math.max(currentLongest, longestSubstring(s, k, start, i));
                start = i + 1;
            }
        }

        if (isGood) {
            return right - left;
        }

        if (right > start) {
            currentLongest = Math.max(currentLongest, longestSubstring(s, k, start, right));
        }
        return currentLongest;
    }
}