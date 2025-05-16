class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        return wordBreak(s, wordDict, 0, new Boolean[s.length()]);
    }

    private boolean wordBreak(String s, List<String> wordDict, int index, Boolean[] memo) {
        if (index == s.length()) {
            return true;
        }
        if (memo[index] != null) {
            return memo[index];
        }

        for (String word : wordDict) {
            if (s.startsWith(word, index)) {
                if (wordBreak(s, wordDict, index + word.length(), memo)) {
                    memo[index] = true;
                    return true;
                }
            }
        }
        memo[index] = false;
        return false;
    }
}