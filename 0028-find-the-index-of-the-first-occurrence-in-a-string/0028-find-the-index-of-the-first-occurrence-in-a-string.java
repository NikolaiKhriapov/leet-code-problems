class Solution {
    public int strStr(String haystack, String needle) {
        int hl = haystack.length();
        int nl = needle.length();

        int ph = 0;
        int pn = 0;

        while (ph < hl) {
            if (haystack.charAt(ph) == needle.charAt(pn)) {
                if (pn == nl - 1) {
                    return ph - pn;
                }
                ph++;
                pn++;
            } else {
                ph = ph - pn + 1;
                pn = 0;
            }
        }
        
        return -1;
    }
}