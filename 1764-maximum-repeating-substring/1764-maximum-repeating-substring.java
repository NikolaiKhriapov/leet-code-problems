class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder repeatedWord = new StringBuilder(word);

        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.contains(repeatedWord)) {
                count++;
                repeatedWord.append(word);
            } else {
                break;
            }
        }

        return count;
    }
}
