class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sMap = new int[256];
        int[] tMap = new int[256];
        Arrays.fill(sMap, -1);
        Arrays.fill(tMap, -1);

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (sMap[cs] == -1 && tMap[ct] == -1) {
                sMap[cs] = ct;
                tMap[ct] = cs;
            } else if (sMap[cs] != ct || tMap[ct] != cs) {
                return false;
            }
        }
        
        return true;
    }
}