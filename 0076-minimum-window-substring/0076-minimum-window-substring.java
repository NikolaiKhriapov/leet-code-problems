class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> mapChars = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapChars.put(c, mapChars.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int requiredCharsCount = mapChars.size();
        int foundCharsCount = 0;
        Map<Character, Integer> mapSeen = new HashMap<>();

        while (right < s.length()) {
            char nextChar = s.charAt(right);
            if (mapChars.containsKey(nextChar)) {
                mapSeen.put(nextChar, mapSeen.getOrDefault(nextChar, 0) + 1);
                if (Objects.equals(mapSeen.get(nextChar), mapChars.get(nextChar))) {
                    foundCharsCount++;
                }
            }
            while (foundCharsCount == requiredCharsCount) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                if (mapSeen.containsKey(leftChar)) {
                    if (Objects.equals(mapSeen.get(leftChar), mapChars.get(leftChar))) {
                        foundCharsCount--;
                    }
                    mapSeen.put(leftChar, mapSeen.get(leftChar) - 1);
                }
                left++;
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}