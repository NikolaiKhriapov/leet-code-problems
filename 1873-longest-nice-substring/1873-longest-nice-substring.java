class Solution {
    public String longestNiceSubstring(String s) {
        return longestNiceSubstring(s, 0, s.length());
    }

    private String longestNiceSubstring(String s, int l, int r) {
        int v = helper(s, l, r);
        if (v >= 0) {
            String left = longestNiceSubstring(s, l, v);
            String right = longestNiceSubstring(s, v + 1, r);

            return left.length() >= right.length() ? left : right;
        }
        return s.substring(l, r);
    }

    private int helper(String s, int l, int r) {
        Set<Character> set = new HashSet<>();
        for (int i = l; i < r; i++) {
            char c = s.charAt(i);
            set.add(c);
        }

        for (int i = l; i < r; i++) {
            char c = s.charAt(i);
            if (!set.contains(Character.toLowerCase(c)) || !set.contains(Character.toUpperCase(c))) {
                return i;
            }
        }
        
        return -1;
    }
}