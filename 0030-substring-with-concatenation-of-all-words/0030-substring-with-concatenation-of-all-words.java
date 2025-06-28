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
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> mapSeen = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String newWord = s.substring(right, right + wordLength);
                right += wordLength;

                if (mapWords.containsKey(newWord)) {
                    mapSeen.put(newWord, mapSeen.getOrDefault(newWord, 0) + 1);
                    count++;
                    
                    while (mapSeen.get(newWord) > mapWords.get(newWord)) {
                        String leftWord = s.substring(left, left + wordLength);
                        left += wordLength;
                        mapSeen.put(leftWord, mapSeen.get(leftWord) - 1);
                        count--;
                    }

                    if (count == wordsCount) {
                        result.add(left);
                    }
                } else {
                    left = right;
                    count = 0;
                    mapSeen = new HashMap<>();
                }
            }
        }
        
        return result;
    }
}