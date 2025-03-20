class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;

        for (int i = 0, sl = s.length(); i < sl - 2; i++) {
            if (isGood(s.charAt(i), s.charAt(i + 1), s.charAt(i + 2))) {
                count++;
            }
        }
        
        return count;
    }

    private boolean isGood(char a, char b, char c) {
        return a != b && b != c && a != c;
    }
}