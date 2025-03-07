class Solution {
    public int countGoodSubstrings(String s) {
        int sl = s.length();
        
        if (sl < 3) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < sl - 2; i++) {
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