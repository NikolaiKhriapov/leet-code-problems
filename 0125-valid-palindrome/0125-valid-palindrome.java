class Solution {
    public boolean isPalindrome(String s) {
        int pl = 0;
        int pr = s.length() - 1;

        while (pl < pr) {
            while (pl < pr && !Character.isLetterOrDigit(s.charAt(pl))) {
                pl++;
            }
            while (pl < pr && !Character.isLetterOrDigit(s.charAt(pr))) {
                pr--;
            }

            if (pl < pr && Character.toLowerCase(s.charAt(pl)) != Character.toLowerCase(s.charAt(pr))) {
                return false;
            }

            pl++;
            pr--;
        }

        return true;
    }
}
