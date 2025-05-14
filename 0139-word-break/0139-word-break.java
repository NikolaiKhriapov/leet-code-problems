class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        return helper(s, wordDict, 0, new HashSet<>());
    }

    private boolean helper(String s, List<String> wordDict, int start, Set<Integer> memo) {
        if (start > s.length()) {
            return false;
        }
        if (start == s.length()) {
            return true;
        }
        if (memo.contains(start)) {
            return false;
        }

        for (String word : wordDict) {
            if (s.startsWith(word, start)) {
                if (helper(s, wordDict, start + word.length(), memo)) {
                    return true;
                }
            }
        }
        memo.add(start);
        return false;
    }
}