class Solution {
    public boolean isPalindrome(String s) {
        char[] sArr = s.toCharArray();

        int pl = 0;
        int pr = sArr.length - 1;

        while (pl < pr) {
            while (pl < pr && !Character.isLetterOrDigit(sArr[pl])) {
                pl++;
            }
            while (pl < pr && !Character.isLetterOrDigit(sArr[pr])) {
                pr--;
            }

            if (pl >= pr) break;

            if (Character.toLowerCase(sArr[pl]) != Character.toLowerCase(sArr[pr])) {
                return false;
            }
            pl++;
            pr--;
        }
        
        return true;
    }
}