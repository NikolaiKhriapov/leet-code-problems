class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String longestPalindrome = "";
        for (int i = 0, sl = s.length(); i < sl; i++) {
            String palindromeA = getLongestPalindrome(s, i, i);
            if (palindromeA.length() > longestPalindrome.length()) {
                longestPalindrome = palindromeA;
            }

            String palindromeB = getLongestPalindrome(s, i, i + 1);
            if (palindromeB.length() > longestPalindrome.length()) {
                longestPalindrome = palindromeB;
            }
        }
        return longestPalindrome;
    }

    private String getLongestPalindrome(String s, int l, int r) {
        int sl = s.length();
        while (l >= 0 && r < sl) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
