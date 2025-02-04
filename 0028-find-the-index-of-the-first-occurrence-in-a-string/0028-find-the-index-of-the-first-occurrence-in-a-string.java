class Solution {
    public int strStr(String haystack, String needle) {
        int pN = 0;
        int pH = 0;
        int p = 0;
        
        int hL = haystack.length();
        int nL = needle.length();

        while (p < hL) {
            if (haystack.charAt(p) != needle.charAt(pN)) {
                pH++;
                p = pH;
                pN = 0;
            } else {
                p++;
                pN++;
            }

            if (p - pH == nL) {
                return pH;
            }
        }

        return -1;
    }
}