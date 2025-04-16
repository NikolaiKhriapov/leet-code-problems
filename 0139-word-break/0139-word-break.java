class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, new HashMap<>());
    }

    private boolean wordBreak(String s, List<String> wordDict, Map<String, Boolean> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        for (String word : wordDict) {
            int index = s.indexOf(word);
            if (index != -1) {
                boolean leftWordBreaks = wordBreak(s.substring(0, index), wordDict, memo);
                boolean rightWordBreaks = wordBreak(s.substring(index + word.length(), s.length()), wordDict, memo);
                if (leftWordBreaks && rightWordBreaks) {
                    return true;
                }
            }
        }

        boolean result = s.length() == 0;
        memo.put(s, result);
        return result;
    }
}