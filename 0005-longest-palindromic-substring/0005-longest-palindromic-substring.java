class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int lengthA = count(s, i, i);
            int lengthB = count(s, i, i + 1);
            int length = Math.max(lengthA, lengthB);

            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }   
        return s.substring(start, end + 1);
    }

    private int count(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}