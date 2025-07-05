class Solution {
    public String minWindow(String s, String t) {

        String result = "";

        Map<Character, Integer> mapChars = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapChars.put(c, mapChars.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int required = mapChars.size();
        int formed = 0;

        Map<Character, Integer> mapSeen = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (mapChars.containsKey(c)) {
                mapSeen.put(c, mapSeen.getOrDefault(c, 0) + 1);
                if (Objects.equals(mapSeen.get(c), mapChars.get(c))) {
                    formed++;
                }
            }
            while (formed == required) {
                if (result.isEmpty() || result.length() > right - left) {
                    result = s.substring(left, right + 1);
                }
                char leftChar = s.charAt(left);
                left++;
                if (mapSeen.containsKey(leftChar)) {
                    mapSeen.put(leftChar, mapSeen.get(leftChar) - 1);
                    if (mapSeen.get(leftChar) < mapChars.get(leftChar)) {
                        formed--;
                    }
                }
            }
            right++;
        }

        return result;
    }
}