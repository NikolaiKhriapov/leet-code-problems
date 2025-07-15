class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = getFrequencyArray(word1);
        int[] freq2 = getFrequencyArray(word2);
        
        boolean isSameChars = isSameChars(freq1, freq2);

        Map<Integer, Integer> freqMap1 = getFrequencyMap(freq1);
        Map<Integer, Integer> freqMap2 = getFrequencyMap(freq2);

        return isSameChars && freqMap1.equals(freqMap2);
    }

    private static int[] getFrequencyArray(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    private static Map<Integer, Integer> getFrequencyMap(int[] arr) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int n : arr) {
            if (n > 0) {
                result.put(n, result.getOrDefault(n, 0) + 1);
            }
        }
        return result;
    }

    private static boolean isSameChars(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if ((arr1[i] == 0 && arr2[i] != 0) || (arr1[i] != 0 && arr2[i] == 0)) {
                return false;
            }
        }
        return true;
    }
}