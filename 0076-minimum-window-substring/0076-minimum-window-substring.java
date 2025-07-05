class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        Map<Character, Integer> mapChars = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapChars.put(c, mapChars.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> mapSeen = new HashMap<>();
        int left = 0;
        int right = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int required = mapChars.size();
        int found = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (mapChars.containsKey(c)) {
                mapSeen.put(c, mapSeen.getOrDefault(c, 0) + 1);
                if (Objects.equals(mapSeen.get(c), mapChars.get(c))) {
                    found++;
                }
            }
            while (required == found) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                left++;
                if (mapSeen.containsKey(leftChar)) {
                    if (Objects.equals(mapSeen.get(leftChar), mapChars.get(leftChar))) {
                        found--;
                    }
                    mapSeen.put(leftChar, mapSeen.get(leftChar) - 1);
                }
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}