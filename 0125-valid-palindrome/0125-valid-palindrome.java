class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int pl = 0;
        int pr = s.length() - 1;

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
