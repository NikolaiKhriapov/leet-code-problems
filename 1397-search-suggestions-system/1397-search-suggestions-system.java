class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if (products == null || searchWord == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        Arrays.sort(products);
        TrieNode root = buildTrie(products);
        return getSuggestions(root, searchWord);
    }

    private List<List<String>> getSuggestions(TrieNode root, String word) {
        List<List<String>> result = new ArrayList<>();
        for (char c : word.toCharArray()) {
            List<String> suggestions = new ArrayList<>();
            if (root != null) {
                root = root.children[c - 'a'];
                if (root != null) {
                    suggestions.addAll(root.suggestions);
                }
            }
            result.add(suggestions);
        }
        return result;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
                if (node.suggestions.size() < 3) {
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