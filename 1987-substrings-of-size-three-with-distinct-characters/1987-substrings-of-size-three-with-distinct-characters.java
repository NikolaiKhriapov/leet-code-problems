class Solution {
    public int countGoodSubstrings(String s) {

        int k = 3;
        int count = 0;

        if (s.length() < 3) return 0;

        int l = 0;
        int r = k - 1;
        while (r < s.length()) {
            if (isGoodSubstring(s.substring(l, r + 1))) {
                count++;
            }
            l++;
            r++;
        }

        return count;        
    }

    private boolean isGoodSubstring(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        if (set.size() == 3) return true;
        return false;
    }
}