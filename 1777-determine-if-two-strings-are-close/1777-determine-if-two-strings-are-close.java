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
        boolean isSameSetOfCharacters = isSameSetOfCharacters(freq1, freq2);

        Arrays.sort(freq1);
        Arrays.sort(freq2);
        boolean isSameCharacterFrequencies = Arrays.equals(freq1, freq2);
        
        return isSameSetOfCharacters && isSameCharacterFrequencies;
    }

    private int[] getFrequencyArray(String word) {
        int[] result = new int[26];
        for (char c : word.toCharArray()) {
            result[c - 'a']++;
        }
        return result;
    }

    private boolean isSameSetOfCharacters(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if ((arr1[i] == 0 && arr2[i] != 0) || (arr1[i] != 0 && arr2[i] == 0)) {
                return false;
            }
        }
        return true;
    }
}