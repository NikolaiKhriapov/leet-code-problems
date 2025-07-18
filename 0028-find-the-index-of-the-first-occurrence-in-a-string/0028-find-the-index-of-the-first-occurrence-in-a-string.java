class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (haystack.length() < needle.length() || haystack.length() == 0) {
            return -1;
        }
        
        int left = 0;
        while (left < haystack.length()) {
            while (left < haystack.length() && haystack.charAt(left) != needle.charAt(0)) {
                left++;
            }
            if (left == haystack.length()) {
                break;
            }
            int right = left;
            for (int i = 0; i < needle.length(); i++) {
                if (right < haystack.length() && haystack.charAt(right) == needle.charAt(i)) {
                    right++;
                } else {
                    break;
                }
            }
            if (right - left == needle.length()) {
                return left;
            }
            left++;
        }
        return -1;
    }
}