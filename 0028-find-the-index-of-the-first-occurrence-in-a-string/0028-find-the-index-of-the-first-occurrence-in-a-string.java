class Solution {
    public int strStr(String haystack, String needle) {
        int counter = 0;
        int ph = 0;
        int pn = 0;

        while (ph < haystack.length()) {
            if (haystack.charAt(ph) == needle.charAt(pn)) {
                if (++counter == needle.length()) {
                    return ph - counter + 1;
                }
                ph++;
                pn++;
            } else {
                ph = ph - counter + 1;
                pn = 0;
                counter = 0;
            }
        }
        
        return -1;
    }
}