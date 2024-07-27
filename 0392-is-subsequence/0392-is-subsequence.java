class Solution {
    public boolean isSubsequence(String s, String t) {

        int ps = 0;
        int pt = 0;

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        while (ps < cs.length && pt < ct.length) {
            if (cs[ps] == ct[pt]) {
                ps++;
                pt++;
            } else {
                pt++;
            }
        }
        
        if (ps == cs.length) return true;
        return false;
    }
}