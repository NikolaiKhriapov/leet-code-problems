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
                char[] currWordArray = currWord.toCharArray();
                for (int i = 0; i < currWordArray.length; i++) {
                    char ch = currWordArray[i];
                    for (int j = 0; j < 26; j++) {
                        currWordArray[i] = (char) ('a' + j);
                        String newWord = String.valueOf(currWordArray);
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            if (Objects.equals(newWord, endWord)) {
                                return count + 1;
                            }
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    currWordArray[i] = ch;
                }
            }
            count++;
        }

        return 0;
    }
}