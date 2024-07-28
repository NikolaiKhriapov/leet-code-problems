class Solution {
    public String longestNiceSubstring(String s) {
        int length = s.length();
        if (length <= 1) return "";

        String longestNice = "";

        int l = 0;
        int r = 1;

        while (l < length) {            
            while (r < length) {
                String curr = s.substring(l, r + 1);

                if (isNice(curr) && curr.length() > longestNice.length()) {
                    longestNice = curr;
                }
                r++;
            }
            l++;
            r = l + 1;
        }
        
        return longestNice;
    }

    private boolean isNice(String s) {
        char[] arr = s.toCharArray();

        Set<Character> set = new HashSet<>();
        for (char c : arr) {
            set.add(c);
        }

        for (char c : arr) {
            if (!set.contains(Character.toUpperCase(c)) || !set.contains(Character.toLowerCase(c))) {
                return false;
            }
        }
        
        return true;
    }
}