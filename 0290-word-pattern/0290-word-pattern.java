class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (arr.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char currP = pattern.charAt(i);
            String currS = arr[i];
            if (map.containsKey(currP) && !Objects.equals(map.get(currP), currS)) {
                return false;
            }
            if (!map.containsKey(currP) && map.containsValue(currS)) {
                return false;
            }
            map.put(currP, currS);
        }

        return true;
    }
}