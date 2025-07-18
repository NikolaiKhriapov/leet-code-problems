class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int hl = haystack.length();
        int nl = needle.length();

        if (hl < nl || hl == 0) {
            return -1;
        }
        
        int left = 0;
        while (left < hl) {
            while (left < hl && haystack.charAt(left) != needle.charAt(0)) {
                left++;
            }
            if (left == hl) {
                break;
            }
            int right = left;
            for (int i = 0; i < nl; i++) {
                if (right < hl && haystack.charAt(right) == needle.charAt(i)) {
                    right++;
                } else {
                    break;
                }
            }
            if (right - left == nl) {
                return left;
            }
            left++;
        }
        return -1;
    }
}

// time  = 
// space = 