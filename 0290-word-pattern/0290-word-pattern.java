class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] parts = s.split(" ");
        if (pattern.length() != parts.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < parts.length; i++) {
            char c = pattern.charAt(i);
            String w = parts[i];

            if (!map.containsKey(c)) {
                if (!set.contains(w)) {
                    map.put(c, w);
                    set.add(w);
                } else {
                    return false;
                }
            } else {
                if (!Objects.equals(map.get(c), w)) {
                    return false;
                }
            }
        }

        return true;        
    }
}