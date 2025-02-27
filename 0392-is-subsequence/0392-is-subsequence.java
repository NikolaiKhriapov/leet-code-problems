class Solution {
    public boolean isSubsequence(String s, String t) {
        int ls = s.length();
        int lt = t.length();

        int ps = 0;
        int pt = 0;
        
        while (ps < ls && pt < lt) {
            if (s.charAt(ps) == t.charAt(pt)) {
                ps++;
            }
            pt++;
        }
        
        return ps == ls;
    }
}