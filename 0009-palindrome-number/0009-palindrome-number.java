class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0) return false;
        if (x <= 9) return true;

        int temp = x;

        int reversed = 0;
        while (temp != 0) {
            int digit = temp % 10;
            temp /= 10;
            reversed = reversed * 10 + digit;
        }

        while (x != 0 || reversed != 0) {
            if (x % 10 != reversed % 10) {
                return false;
            }
            x /= 10;
            reversed /= 10;
        }

        return x == 0 && reversed == 0;
    }
}