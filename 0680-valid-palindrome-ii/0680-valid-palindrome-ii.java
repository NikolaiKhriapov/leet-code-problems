class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length() - 1, false);
    }

    private boolean validPalindrome(String s, int l, int r, boolean isDeleted) {
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                if (isDeleted) return false;
                return validPalindrome(s, l, r - 1, true) || validPalindrome(s, l + 1, r, true);
            }
        }
        
        return true;

    }
}