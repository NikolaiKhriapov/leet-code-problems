class Solution {
    public int maxVowels(String s, int k) {
        if (s == null || k < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (s.isBlank() || k == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int maxVowelCount = 0;
        int currVowelCount = 0;

        while (right < s.length()) {
            if (isVowel(s.charAt(right))) {
                currVowelCount++;
            }
            right++;
            if (right - left > k) {
                if (isVowel(s.charAt(left))) {
                    currVowelCount--;
                }
                left++;
            }
            maxVowelCount = Math.max(maxVowelCount, currVowelCount);
        }
        
        return maxVowelCount;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}