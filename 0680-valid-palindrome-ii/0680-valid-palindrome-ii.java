class Solution {
    public boolean validPalindrome(String s) {

        char[] arr = s.toCharArray();

        return isPalindrome(arr, 0, arr.length - 1, false);
    }

    private boolean isPalindrome(char[] arr, int l, int r, boolean deleted) {
        while (l < r) {
            if (arr[l] != arr[r]) {
                if (deleted) return false;
                return isPalindrome(arr, l + 1, r, true) || isPalindrome(arr, l, r - 1, true);
            }
            l++;
            r--;
        }

        return true;
    }
}