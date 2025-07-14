class Solution {
    public int maxVowels(String s, int k) {
        if (s == null || k < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0;
        int right = 0;
        int currCount = 0;
        int maxCount = 0;

        while (right < s.length()) {
            if (isVowel(s.charAt(right))) {
                currCount++;
            }
            right++;
            if (right - left > k) {
                if (isVowel(s.charAt(left))) {
                    currCount--;
                }
                left++;
            }
            maxCount = Math.max(maxCount, currCount);
        }
        
        return maxCount;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}