class Solution {
    public int strStr(String haystack, String needle) {
        int pN = 0;
        int pH = 0;
        int p = 0;
        
        while (p < haystack.length()) {
            if (haystack.charAt(p) != needle.charAt(pN)) {
                pH++;
                p = pH;
                pN = 0;
            } else {
                p++;
                pN++;
            }

            if (p - pH == needle.length()) {
                return pH;
            }
        }

        return -1;
    }
}