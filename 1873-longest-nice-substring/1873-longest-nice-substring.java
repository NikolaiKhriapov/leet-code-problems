class Solution {
    public String longestNiceSubstring(String s) {
        int sl = s.length();

        int p = isNice(s);
        if (p != -1) {
            String l = longestNiceSubstring(s.substring(0, p));
            String r = longestNiceSubstring(s.substring(p + 1, sl));
            s = l.length() >= r.length() ? l : r;
        }

        return s;
    }

    private int isNice(String s) {
        Set<Character> set = new HashSet<>();
        
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        int sl = s.length();
        for (int i = 0; i < sl; i++) {
            char c = s.charAt(i);
            if (!set.contains(Character.toLowerCase(c)) || !set.contains(Character.toUpperCase(c))) {
                return i;
            }
        }

        return -1;
    }
}