class Solution {
    public String longestNiceSubstring(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        return longestNiceSubstring(s, 0, s.length() - 1);
    }

    private String longestNiceSubstring(String s, int left, int right) {
        Set<Character> set = new HashSet<>();
        for (int i = left; i <= right; i++) {
            set.add(s.charAt(i));
        }

        for (int i = left; i <= right; i++) {
            char c = s.charAt(i);
            if (!set.contains(Character.toLowerCase(c)) || !set.contains(Character.toUpperCase(c))) {
                String longestLeft = longestNiceSubstring(s, left, i - 1);
                String longestRight = longestNiceSubstring(s, i + 1, right);
                return longestLeft.length() >= longestRight.length() ? longestLeft : longestRight;
            }
        }

        return s.substring(left, right + 1);
    }
}

// time  - O(n,2)
// space - O(n)