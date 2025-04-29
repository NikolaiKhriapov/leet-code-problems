class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Boolean[] memo = new Boolean[s.length()];
        return wordBreak(s, 0, wordDict, memo);
    }

    public boolean wordBreak(String s, int currentIndex, List<String> wordDict, Boolean[] memo) {
        if (currentIndex > s.length()) return false;
        if (currentIndex == s.length()) return true;

        if (memo[currentIndex] != null) return memo[currentIndex];

        for (String word : wordDict) {
            if (s.startsWith(word, currentIndex)) {
                if (wordBreak(s, currentIndex + word.length(), wordDict, memo)) {
                    return true;
                }
            }
        }

        memo[currentIndex] = false;
        return false;
    }
}
