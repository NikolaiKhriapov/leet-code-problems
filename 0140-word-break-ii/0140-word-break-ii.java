class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        return helper(s, wordDict, 0);
    }

    private List<String> helper(String s, List<String> wordDict, int idx) {
        List<String> result = new ArrayList<>();

        if (idx == s.length()) {
            result.add("");
            return result;
        }

        for (String word : wordDict) {
            if (s.startsWith(word, idx)) {
                List<String> subs = helper(s, wordDict, idx + word.length());
                for (String sub : subs) {
                    String optionalSpace = sub.isEmpty() ? "" : " ";
                    result.add(word + optionalSpace + sub);
                }
            }
        }

        return result;
    }
}