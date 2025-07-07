class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null || s.isEmpty() || wordDict.isEmpty()) {
            return new ArrayList<>();
        }
        return helper(s, wordDict, 0, new HashMap<>());
    }

    private List<String> helper(String s, List<String> wordDict, int idx, Map<Integer, List<String>> memo) {
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }

        List<String> result = new ArrayList<>();

        if (idx >= s.length()) {
            result.add("");
            return result;
        }

        for (String word : wordDict) {
            if (s.startsWith(word, idx)) {
                List<String> sublist = helper(s, wordDict, idx + word.length(), memo);
                for (String sub : sublist) {
                    String spaceOptional = sub.isEmpty() ? "" : " ";
                    result.add(word + spaceOptional + sub);
                }
            }
        }

        memo.put(idx, result);
        return result;
    }
}