class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int xReversed = 0;
        while (x > xReversed) {
            int digit = x % 10;
            x /= 10;
            xReversed = xReversed * 10 + digit;
        }
        
        return x == xReversed || x == xReversed / 10;
    }
}

// time  - O(log n)
// space - O(1)