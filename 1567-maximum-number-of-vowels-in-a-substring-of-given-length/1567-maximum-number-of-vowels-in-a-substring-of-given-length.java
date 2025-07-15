class Solution {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

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
            if (VOWELS.contains(s.charAt(right++))) {
                currCount++;
            }
            if (right - left > k) {
                if (VOWELS.contains(s.charAt(left++))) {
                    currCount--;
                }
            }
            maxCount = Math.max(maxCount, currCount);
        }
        return maxCount;
    }
}