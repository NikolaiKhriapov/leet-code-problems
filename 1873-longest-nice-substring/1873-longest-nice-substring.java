class Solution {
    public String longestNiceSubstring(String s) {
        int v  = helper(s);
        if (v >= 0) {
            String left = longestNiceSubstring(s.substring(0, v));
            String right = longestNiceSubstring(s.substring(v + 1, s.length()));

            s = left.length() >= right.length() ? left : right;
        }
        return s;
    }

    private int helper(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(Character.toLowerCase(c)) || !set.contains(Character.toUpperCase(c))) {
                return i;
            }
        }
        
        return -1;
    }
}