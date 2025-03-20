class Solution {
    public String longestNiceSubstring(String s) {
        return helper(s, 0, s.length());
    }

    private String helper(String s, int l, int r) {
        if (r - l < 2) return "";

        Set<Character> set = new HashSet<>();
        for (int i = l; i < r; i++) {
            set.add(s.charAt(i));
        }

        for (int i = l; i < r; i++) {
            char c = s.charAt(i);
            if (!set.contains(Character.toLowerCase(c)) || !set.contains(Character.toUpperCase(c))) {
                String left = helper(s, l, i);
                String right = helper(s, i + 1, r);
                return left.length() >= right.length() ? left : right;
            }
        }

        return s.substring(l, r);
    }
}