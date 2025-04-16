class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, new HashMap<>());
    }

    private boolean wordBreak(String s, List<String> wordDict, Map<String, Boolean> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (wordBreak(s.substring(0 + word.length(), s.length()), wordDict, memo)) {
                    memo.put(s, true);
                    return true;
                }
            }
        }

        boolean result = s.length() == 0;
        memo.put(s, result);
        return result;
    }
}