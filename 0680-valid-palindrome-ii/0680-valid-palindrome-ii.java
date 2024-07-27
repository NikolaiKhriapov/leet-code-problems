class Solution {
    public boolean validPalindrome(String s) {

        return isPalindrome(s, 0, s.length() - 1, false);
    }

    private boolean isPalindrome(String s, int l, int r, boolean deleted) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (deleted) return false;
                return isPalindrome(s, l + 1, r, true) || isPalindrome(s, l, r - 1, true);
            }
            l++;
            r--;
        }

        return true;
    }
}