class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String longestPalindrome = "";

        for (int i = 0, sl = s.length(); i < sl; i++) {
            int l = i;
            int r = l;
            while (l >= 0 && r < sl) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }
                l--;
                r++;
            }
            String palindrome = s.substring(l + 1, r);
            if (palindrome.length() > longestPalindrome.length()) {
                longestPalindrome = palindrome;
            }

            l = i;
            r = l + 1;
            while (l >= 0 && r < sl) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }
                l--;
                r++;
            }
            palindrome = s.substring(l + 1, r);
            if (palindrome.length() > longestPalindrome.length()) {
                longestPalindrome = palindrome;
            }
        }

        return longestPalindrome;
    }
}
