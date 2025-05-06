class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        if (s.length() <= 1) {
            return s;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int lengthOdd = getLongestPalindrome(s, i, i);
            int lengthEven = getLongestPalindrome(s, i, i + 1);
            int length = Math.max(lengthOdd, lengthEven);
            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int getLongestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}