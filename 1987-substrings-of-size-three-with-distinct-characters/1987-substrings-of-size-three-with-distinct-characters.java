class Solution {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }

        int count = 0;
        char[] sArr = s.toCharArray();

        for (int i = 0; i <= s.length() - 3; i++) {
            if (isGood(sArr[i], sArr[i + 1], sArr[i + 2])) {
                count++;
            }
        }

        return count;
    }

    private boolean isGood(char a, char b, char c) {
        return a != b && b != c && a != c;
    }
}