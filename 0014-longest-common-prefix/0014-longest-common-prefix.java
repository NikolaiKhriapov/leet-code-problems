class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (strs.length == 0) {
            return "";
        }

        for (int i = 0; i <= strs[0].length(); i++) {
            if (i == strs[0].length()) {
                return strs[0].substring(0, i);
            }
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return "";
    }
}

// time - O(m*n)
// space - O(1)