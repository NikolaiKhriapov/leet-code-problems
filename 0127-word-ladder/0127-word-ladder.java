class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String word = queue.poll();
                char[] wordArr = word.toCharArray();
                for (int i = 0; i < wordArr.length; i++) {
                    char oldChar = wordArr[i];
                    for (int j = 0; j < 26; j++) {
                        wordArr[i] = (char) ('a' + j);
                        String newWord = String.valueOf(wordArr);
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            if (Objects.equals(newWord, endWord)) {
                                return count + 1;
                            }
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    wordArr[i] = oldChar;
                }
            }
            count++;
        }

        return 0;
    }
}