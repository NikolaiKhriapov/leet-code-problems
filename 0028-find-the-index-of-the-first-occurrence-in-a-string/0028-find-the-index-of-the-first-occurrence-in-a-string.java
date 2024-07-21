class Solution {
    public int strStr(String haystack, String needle) {

        int h = 0;
        int n = 0;

        while (h < haystack.length()) {
            if (haystack.charAt(h) == needle.charAt(n)) {
                h++;
                n++;
                if (n == needle.length()) return h - n;
            } else {
                h = h - n + 1;
                n = 0;
            }
        }

        return -1;
    }
}