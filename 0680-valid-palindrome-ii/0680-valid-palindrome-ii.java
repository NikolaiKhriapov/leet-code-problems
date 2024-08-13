class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, false);
    }

    private boolean validPalindrome(String s, boolean isDeleted) {
        char[] arr = s.toCharArray();

        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            if (arr[l] != arr[r]) {
                if (isDeleted) {
                    return false;
                } else {
                    return validPalindrome(s.substring(l, r), true) || validPalindrome(s.substring(l + 1, r + 1), true);
                }
            }
            l++;
            r--;
        }
        
        return true;

    }
}