class Solution {
    public boolean isPalindrome(String s) {
        
        int pl = 0;
        int pr = s.length() - 1;

        while (pl < pr) {
            char cl = Character.toLowerCase(s.charAt(pl));
            char cr = Character.toLowerCase(s.charAt(pr));

            if (!Character.isLetterOrDigit(cl)) pl++;
            else if (!Character.isLetterOrDigit(cr)) pr--;
            else {
                if (cl != cr) return false;
                pl++;
                pr--;
            }
        }

        return true;
    }
}