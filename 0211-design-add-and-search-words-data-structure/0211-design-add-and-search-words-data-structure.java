class WordDictionary {
    private TrieNode root;

    private static final char DOT = '.';

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.isEnd;
        }

        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == DOT) {
                for (TrieNode child : node.children) {
                    if (search(word, index + 1, child)) {
                        return true;
                    }
                }
            } else if (node.children[c - 'a'] != null) {
                return search(word, index + 1, node.children[c - 'a']);
            } else {
                return false;
            }
        }
        return false;
    }

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */