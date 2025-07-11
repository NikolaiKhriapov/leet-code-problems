class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (s.length() < t.length() || s.isEmpty()) {
            return "";
        }
        
        Map<Character, Integer> mapChars = new HashMap<>();
        for (char ch : t.toCharArray()) {
            mapChars.put(ch, mapChars.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> mapSeen = new HashMap<>();        
        int requiredChars = mapChars.size();
        int foundChars = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (mapChars.containsKey(rightChar)) {
                mapSeen.put(rightChar, mapSeen.getOrDefault(rightChar, 0) + 1);
                if (Objects.equals(mapChars.get(rightChar), mapSeen.get(rightChar))) {
                    foundChars++;
                }
            }
            while (foundChars == requiredChars) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                if (mapChars.containsKey(leftChar)) {
                    if (Objects.equals(mapChars.get(leftChar), mapSeen.get(leftChar))) {
                        foundChars--;
                    }
                    mapSeen.put(leftChar, mapSeen.get(leftChar) - 1);
                }
                left++;
            }
            right++;
        }

        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(start, start + minLength);
    }
}