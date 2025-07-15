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

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return isSameChars && Arrays.equals(freq1, freq2);
    }

    private static int[] getFrequencyArray(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
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