class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (s.isEmpty() || wordDict.size() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        helper(s, wordDict, 0, new StringBuilder(), result);
        return result;
    }

    private void helper(String s, List<String> wordDict, int idx, StringBuilder curr, List<String> result) {
        if (idx == s.length()) {
            result.add(curr.toString());
            return;
        }

        int currLength = curr.length();
        for (String word : wordDict) {
            if (s.startsWith(word, idx)) {
                if (!curr.isEmpty()) {
                    curr.append(" ");
                }
                curr.append(word);
                helper(s, wordDict, idx + word.length(), curr, result);
                curr.delete(currLength, curr.length());
            }
        }
    }
}