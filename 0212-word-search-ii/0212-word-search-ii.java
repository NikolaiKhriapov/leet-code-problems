class Solution {
    private static final int[][] NEIGHBORS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final char MARK_VISITED = '#';

    private class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                helper(board, root, r, c, result);
            }
        }

        return result;
    }

    private void helper(char[][] board, TrieNode node, int r, int c, List<String> result) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;
        char ch = board[r][c];
        if (ch == MARK_VISITED || node.children[ch - 'a'] == null) return;

        board[r][c] = MARK_VISITED;

        node = node.children[ch - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        for (int[] neighbor : NEIGHBORS) {
            helper(board, node, r + neighbor[0], c + neighbor[1], result);
        }

        board[r][c] = ch;
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
            }
            node.word = word;
        }
        return root;
    }
}