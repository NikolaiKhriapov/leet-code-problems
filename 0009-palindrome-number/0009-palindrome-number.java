class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false;
        if (x <= 9) return true;

        int xReversed = 0;
        while (xReversed < x) {
            int digit = x % 10;
            x /= 10;
            xReversed = xReversed * 10 + digit;
        }
        
        return x == xReversed || x == xReversed / 10;
    }
}