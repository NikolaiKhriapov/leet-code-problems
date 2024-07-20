class Solution {
    public String removeDuplicates(String s) {
        char[] sChars = s.toCharArray();

        int left = -1;
        
        for(char ch : sChars) {
            if (left >= 0 && ch == sChars[left]) {
                left--;
            } else {
                sChars[++left] = ch;
            }
        }
        return new String(sChars, 0, left +1);
    }
}