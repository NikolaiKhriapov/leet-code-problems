class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            String currentLongest = getLongestPalindrome(s, i, i);
            if (currentLongest.length() > longestPalindrome.length()) {
                longestPalindrome = currentLongest;
            }

            currentLongest = getLongestPalindrome(s, i, i + 1);
            if (currentLongest.length() > longestPalindrome.length()) {
                longestPalindrome = currentLongest;
            }
        }
        return longestPalindrome;
    }

    private String getLongestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
