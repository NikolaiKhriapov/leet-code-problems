class Solution {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0;
        int p2 = 0;

        int sLength = s.length();
        int tLength = t.length();

        while (p1 < sLength && p2 < tLength) {
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