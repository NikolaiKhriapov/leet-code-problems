class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Map<String, Integer> mapWords = new HashMap<>();
        for (String word : words) {
            mapWords.put(word, mapWords.getOrDefault(word, 0) + 1);
        }

        int wordLength = words[0].length();
        int wordsCount = words.length;
        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> mapSeen = new HashMap<>();
            int left = i;
            int right = left;
            int count = 0;
            while (right + wordLength <= s.length()) {
                String nextWord = s.substring(right, right + wordLength);
                right += wordLength;
                if (mapWords.containsKey(nextWord)) {
                    mapSeen.put(nextWord, mapSeen.getOrDefault(nextWord, 0) + 1);
                    count++;
                    while (mapSeen.get(nextWord) > mapWords.get(nextWord)) {
                        String leftWord = s.substring(left, left + wordLength);
                        mapSeen.put(leftWord, mapSeen.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }
                    if (count == wordsCount) {
                        result.add(left);
                    }
                } else {
                    count = 0;
                    mapSeen = new HashMap<>();
                    left = right;
                }
            }
        }

        return result;
    }
}