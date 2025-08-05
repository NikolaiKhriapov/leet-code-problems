class Solution {
    public String longestPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (s.length() <= 1) {
            return s;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int evenLength = getCurrentLongest(s, i, i + 1);
            int oddLength = getCurrentLongest(s, i, i);
            int length = Math.max(evenLength, oddLength);
            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int getCurrentLongest(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - (left + 1);
    }
}
// cbbd
// time  - O(n2)
// space - O(1)