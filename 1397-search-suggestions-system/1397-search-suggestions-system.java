class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if (products == null || searchWord == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        Arrays.sort(products);
        TrieNode root = buildTrie(products);
        return getSuggestions(root, searchWord);
    }

    private List<List<String>> getSuggestions(TrieNode root, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;
        for (char ch : searchWord.toCharArray()) {
            List<String> suggestions = new ArrayList<>();
            if (node != null) {
                node = node.children[ch - 'a'];
                if (node != null) {
                    suggestions.addAll(node.suggestions);
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
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
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