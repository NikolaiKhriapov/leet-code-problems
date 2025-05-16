class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (s.isEmpty()) {
            return true;
        }
        if (wordDict.size() == 0) {
            return false;
        }

        Boolean[] memo = new Boolean[s.length()];
        return wordBreak(s, wordDict, 0, memo);
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