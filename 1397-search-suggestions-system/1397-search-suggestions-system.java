class Solution {
    private static final int SUGGESTIONS_SIZE = 3;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if (products == null || searchWord == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Arrays.sort(products);
        TrieNode root = buildTrie(products);
        return getSuggestions(root, searchWord);
    }

    private List<List<String>> getSuggestions (TrieNode root, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        for (char ch : searchWord.toCharArray()) {
            List<String> suggestions = new ArrayList<>();
            if (root != null) {
                root = root.children[ch - 'a'];
                if (root != null) {
                    suggestions.addAll(root.suggestions);
                }
            }
            result.add(suggestions);
        }
        return result;
    }

    private TrieNode buildTrie(String[] products) {
        TrieNode root = new TrieNode();
        for (String word : products) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
                if (node.suggestions.size() < SUGGESTIONS_SIZE) {
                    node.suggestions.add(word);
                }
            }
        }
        return root;
    }

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }
}