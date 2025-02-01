class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        if (strs.length == 0) {
            return "";
        }
        
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (String s : strs) {
                if (i > s.length() - 1 || s.charAt(i) != c) {
                    return result.toString();
                }
            }
            result.append(c);
        }
        
        return result.toString();
    }
}