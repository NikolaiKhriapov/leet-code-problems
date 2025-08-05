class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (s.length() <= 1) {
            return s;
        }

        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String even = getCurrentLongest(s, i, i + 1);
            String odd = getCurrentLongest(s, i, i);
            String currentLongest = even.length() >= odd.length() ? even : odd;
            longest = currentLongest.length() > longest.length() ? currentLongest : longest;
        }
        return longest;
    }

    private String getCurrentLongest(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}

// time  - O(n)
// space - O(n)