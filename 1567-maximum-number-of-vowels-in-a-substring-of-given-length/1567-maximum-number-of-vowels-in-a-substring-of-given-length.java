class Solution {
    public int maxVowels(String s, int k) {
        if (s == null || k < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (k == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int maxCount = 0;
        int currCount = 0;
        while (right < s.length()) {
            if (isVowel(s.charAt(right++))) {
                currCount++;
            }
            if (right - left > k) {
                if (isVowel(s.charAt(left++))) {
                    currCount--;
                }
            }
            maxCount = Math.max(maxCount, currCount);
        }
        return maxCount;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}