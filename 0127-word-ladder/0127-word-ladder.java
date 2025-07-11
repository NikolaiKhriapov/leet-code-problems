class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length() || wordList == null) {
            throw new IllegalArgumentException("Invalid input");
        }

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
                String currWord = queue.poll();
                char[] currWordArr = currWord.toCharArray();
                for (int i = 0; i < currWordArr.length; i++) {
                    char currChar = currWordArr[i];
                    for (int j = 0; j < 26; j++) {
                        currWordArr[i] = (char) ('a' + j);
                        String newWord = String.valueOf(currWordArr);
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return count + 1;
                            }
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    currWordArr[i] = currChar;
                }
            }
            count++;
        }

        return 0;
    }
}