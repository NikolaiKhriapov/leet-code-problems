class Solution {
    public int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        int pN = 0;
        int pH = 0;
        int p = 0;
        
        while (p < haystackLength) {
            if (haystack.charAt(p) != needle.charAt(pN)) {
                pH++;
                p = pH;
                pN = 0;
            } else {
                p++;
                pN++;
            }

            if (p - pH == needleLength) {
                return pH;
            }
        }

        return -1;
    }
}