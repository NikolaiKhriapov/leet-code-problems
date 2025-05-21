class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        return longestSubstring(s, k, 0, s.length());
    }

    private int longestSubstring(String s, int k, int left, int right) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = left; i < right; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean isValid = true;
        int currentLongest = 0;
        int start = left;
        for (int i = left; i < right; i++) {
            if (map.get(s.charAt(i)) < k) {
                isValid = false;
                currentLongest = Math.max(currentLongest, longestSubstring(s, k, start, i));
                start = i + 1;
            }
        }

        if (isValid) {
            return right - left;
        }
        
        if (right > start) {
            currentLongest = Math.max(currentLongest, longestSubstring(s, k, start, right));
        }
        return currentLongest;
    }
}