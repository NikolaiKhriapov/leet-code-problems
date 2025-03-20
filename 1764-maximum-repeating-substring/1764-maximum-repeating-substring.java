class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        
        StringBuilder sb = new StringBuilder(word);
        while (sequence.indexOf(sb.toString()) != -1) {
            count++;
            sb.append(word);
        }

        return count;
    }
}