class Solution {
    public boolean isSubsequence(String s, String t) {

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        int ps = 0;
        int pt = 0;

        while (ps < sArray.length && pt < tArray.length) {
            if (sArray[ps] == tArray[pt]) {
                ps++;
            }
            pt++;
        }
        
        return ps == sArray.length;
    }
}