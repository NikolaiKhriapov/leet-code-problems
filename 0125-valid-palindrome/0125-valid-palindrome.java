class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int sl = s.length();

        int pl = 0;
        int pr = sl - 1;

        while (pl < pr) {
            char plc = s.charAt(pl);
            char prc = s.charAt(pr);

            if (!Character.isLetterOrDigit(plc)) {
                pl++;
                continue;
            }
            if (!Character.isLetterOrDigit(prc)) {
                pr--;
                continue;
            }

            if (plc != prc) {
                return false;
            }

            pl++;
            pr--;
        }

        return true;
    }
}
