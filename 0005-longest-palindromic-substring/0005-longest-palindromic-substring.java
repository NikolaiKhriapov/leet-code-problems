class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        if (s.length() <= 1) {
            return s;
        }

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            String currentLongest = getLongestPalindrome(s, i, i);
            longest = currentLongest.length() > longest.length() ? currentLongest : longest;

            currentLongest = getLongestPalindrome(s, i, i + 1);
            longest = currentLongest.length() > longest.length() ? currentLongest : longest;
        }
        
        return longest;
    }

    private static String getLongestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}