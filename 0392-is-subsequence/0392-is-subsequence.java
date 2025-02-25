class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int ps = 0;
        int pt = 0;

        while (ps < sArr.length && pt < tArr.length) {
            if (sArr[ps] == tArr[pt]) {
                ps++;
            }
            pt++;
        }
        
        return ps == sArr.length;
    }
}