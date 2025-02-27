class Solution {
    public boolean isSubsequence(String s, String t) {

        int ps = 0;
        int pt = 0;
        
        while (ps < s.length() && pt < t.length()) {
            char cs = s.charAt(ps);
            char ct = t.charAt(pt);

            if (cs == ct) {
                ps++;
            }
            pt++;
        }
        
        return ps == s.length();
    }
}