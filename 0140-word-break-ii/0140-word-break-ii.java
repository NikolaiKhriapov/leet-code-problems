class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        return helper(s, wordDict, 0, new HashMap<>());
    }

    private List<String> helper(String s, List<String> wordDict, int idx, Map<Integer, List<String>> memo) {
        List<String> result = new ArrayList<>();

        if (idx == s.length()) {
            result.add("");
            return result;
        }

        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }

        for (String word : wordDict) {
            if (s.startsWith(word, idx)) {
                List<String> subs = helper(s, wordDict, idx + word.length(), memo);
                for (String sub : subs) {
                    String optionalSpace = sub.isEmpty() ? "" : " ";
                    result.add(word + optionalSpace + sub);
                }
            }
        }

        memo.put(idx, result);
        return result;
    }
}