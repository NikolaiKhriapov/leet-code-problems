class Solution {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        if (s == null || k < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0;
        int right = 0;
        int currCount = 0;
        int maxCount = 0;

        while (right < s.length()) {
            if (VOWELS.contains(s.charAt(right))) {
                currCount++;
            }
            right++;
            if (right - left > k) {
                if (VOWELS.contains(s.charAt(left))) {
                    currCount--;
                }
                left++;
            }
            maxCount = Math.max(maxCount, currCount);
        }
        
        return maxCount;
    }
}