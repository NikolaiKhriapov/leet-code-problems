class Solution {
    public int maxRepeating(String sequence, String word) {

        int count = 0;
        String repeatedWord = word;

        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.contains(repeatedWord)) {
                count++;
                repeatedWord += word;
            } else break;
        }

        return count;
    }
}
