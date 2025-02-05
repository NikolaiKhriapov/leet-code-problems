class Solution {
    public boolean isSubsequence(String s, String t) {

        int p1 = 0;
        int p2 = 0;

        while (p1 < s.length() && p2 < t.length()) {
            char cs = s.charAt(p1);
            char ct = t.charAt(p2);
            
            if (cs == ct) {
                p1++;
            }
            p2++;
        }

        if (p1 == s.length()) {
            return true;
        }
        
        return false;
    }
}