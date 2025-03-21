class Solution {
    public String longestNiceSubstring(String s) {
        return longestNiceSubstring(s, 0, s.length());
    }

    private String longestNiceSubstring(String s, int l, int r) {
        Set<Character> set = new HashSet<>();
        for (int i = l; i < r; i++) {
            set.add(s.charAt(i));
        }

        for (int i = l; i < r; i++) {
            char c = s.charAt(i);
            if (!set.contains(Character.toLowerCase(c)) || !set.contains(Character.toUpperCase(c))) {
                String left = longestNiceSubstring(s, l, i);
                String right = longestNiceSubstring(s, i + 1, r);
                return left.length() >= right.length() ? left : right;
            }
        }
        return s.substring(l, r);
    }
}