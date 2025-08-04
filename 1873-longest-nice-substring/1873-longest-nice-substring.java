class Solution {
    public String longestNiceSubstring(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        return longestNiceSubstring(s, 0, s.length() - 1);
    }

    public String longestNiceSubstring(String s, int left, int right) {
        Set<Character> set = new HashSet<>();
        for (int i = left; i <= right; i++) {
            set.add(s.charAt(i));
        }

        for (int i = left; i <= right; i++) {
            if (!set.contains(Character.toLowerCase(s.charAt(i))) || !set.contains(Character.toUpperCase(s.charAt(i)))) {
                String longestA = longestNiceSubstring(s, left, i - 1);
                String longestB = longestNiceSubstring(s, i + 1, right);
                return longestA.length() >= longestB.length() ? longestA : longestB;
            }
        }
        return s.substring(left, right + 1);
    }
}

// time  - O(n)
// space - O(n)