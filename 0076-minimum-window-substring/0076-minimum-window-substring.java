class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> mapChars = new HashMap<>();
        for (char ch : t.toCharArray()) {
            mapChars.put(ch, mapChars.getOrDefault(ch, 0) + 1);
        }
        
        Map<Character, Integer> mapSeen = new HashMap<>();
        int left = 0;
        int right = left;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int requiredSize = mapChars.size();
        int currentSize = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (mapChars.containsKey(ch)) {
                mapSeen.put(ch, mapSeen.getOrDefault(ch, 0) + 1);
                if (Objects.equals(mapSeen.get(ch), mapChars.get(ch))) {
                    currentSize++;
                }
            }
            while (currentSize == requiredSize) {
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                if (mapChars.containsKey(leftChar)) {
                    if (Objects.equals(mapSeen.get(leftChar), mapChars.get(leftChar))) {
                        currentSize--;
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