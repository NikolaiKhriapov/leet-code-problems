class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int lengthOdd = getMaxLength(s, i, i);
            int lengthEven = getMaxLength(s, i, i + 1);
            int length = Math.max(lengthOdd, lengthEven);
            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }

    private int getMaxLength(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}