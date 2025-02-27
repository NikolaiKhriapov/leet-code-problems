class Solution {
    public boolean isSubsequence(String s, String t) {
        int ls = s.length();
        int lt = t.length();

        int ps = 0;
        int pt = 0;
        
        while (ps < ls && pt < lt) {
            char cs = s.charAt(ps);
            char ct = t.charAt(pt);

            if (cs == ct) {
                ps++;
            }
            pt++;
        }
        
        return ps == ls;
    }
}