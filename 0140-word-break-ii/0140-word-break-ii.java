class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null || s.isEmpty() || wordDict.isEmpty()) {
            return new ArrayList<>();
        }

        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }

        List<String> result = new ArrayList<>();
        
        StringBuilder curr = new StringBuilder();
        helper(s, wordSet, 0, curr, result);
        
        return result;
    }

    private void helper(String s, Set<String> wordSet, int idx, StringBuilder curr, List<String> result) {
        if (idx >= s.length()) {
            result.add(curr.toString());
            return;
        }

        int currLength = curr.length();
        for (String word : wordSet) {
            if (s.startsWith(word, idx)) {
                if (!curr.isEmpty()) {
                    curr.append(" ");
                }
                curr.append(word);
                helper(s, wordSet, idx + word.length(), curr, result);
                curr.delete(currLength, curr.length());
            }
        }
    }
}