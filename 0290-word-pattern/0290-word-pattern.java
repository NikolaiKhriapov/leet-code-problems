class Solution {
    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        String[] words = s.split(" ");
        
        if (pattern.length() != words.length) {
            return false;
        }

        String[] map = new String[26];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (map[c - 'a'] == null) {
                if (set.contains(word)) {
                    return false;
                } else {
                    map[c - 'a'] = word;
                    set.add(word);
                }
            } else {
                if (!Objects.equals(map[c - 'a'], word)) {
                    return false;
                }
            }
        }

        return true;
    }
}

// time. - O(n)
// space - O(n)