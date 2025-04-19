class Solution {
    public String longestPalindrome(String s) {
        if (s == null) return "";
        if (s.length() < 2) return s;
        
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            String currLongest = getLongestSubstring(s, i, i);
            longest = currLongest.length() > longest.length() ? currLongest : longest;

            currLongest = getLongestSubstring(s, i, i + 1);
            longest = currLongest.length() > longest.length() ? currLongest : longest;
        }
        
        return longest;
    }

    private static String getLongestSubstring(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}