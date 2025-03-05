class Solution {
    public boolean isPalindrome(String s) {
        char[] sArr = s.toCharArray();

        int l = 0;
        int r = sArr.length - 1;
        
        while (l < r) {
            while (l < r && !isAlphanumeric(sArr[l])) {
                l++;
            }
            while (r > l && !isAlphanumeric(sArr[r])) {
                r--;
            }
            
            if (l >= r) return true;
            if (Character.toLowerCase(sArr[l]) != Character.toLowerCase(sArr[r])) return false;

            l++;
            r--;
        }

        return true;
    }

    private boolean isAlphanumeric(char c) {
        return Character.isLetterOrDigit(c);
    }
}