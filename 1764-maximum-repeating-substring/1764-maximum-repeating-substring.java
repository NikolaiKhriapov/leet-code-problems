class Solution {
    public int maxRepeating(String sequence, String word) {
        StringBuilder sb = new StringBuilder(word);
        int count = 0;
        
        while (sequence.contains(sb)) {
            sb.append(word);
            count++;
        }

        return count;
    }
}