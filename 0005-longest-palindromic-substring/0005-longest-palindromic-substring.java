class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        if (s.length() == 1) return s;

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int longestOdd = calculateLongest(s, i, i);
            int longestEven = calculateLongest(s, i, i + 1);
            int longest = Math.max(longestOdd, longestEven);
            if (longest > end - start) {
                start = i - (longest - 1) / 2;
                end = i + longest / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int calculateLongest(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}