class Solution {
    private static final int GOOD_SIZE = 3;

    public int countGoodSubstrings(String s) {
        if (s == null) {
            throw new IllegalArgumentException("INnvalid input");
        }
        if (s.length() < GOOD_SIZE) {
            return 0;
        }

        int goodSubstringsCount = 0;
        for (int i = 2; i < s.length(); i++) {
            if (isDifferent(s.charAt(i - 2), s.charAt(i - 1), s.charAt(i))) {
                goodSubstringsCount++;
            }
        }
        return goodSubstringsCount;
    }

    private static boolean isDifferent(char a, char b, char c) {
        return a != b && b != c && a != c;
    }
}

// time  - O(n)
// space - O(1)
