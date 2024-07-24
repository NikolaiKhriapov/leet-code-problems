class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] alphabetcounter = new int[26];

        for (char c : magazine.toCharArray()) {
            alphabetcounter[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (alphabetcounter[c - 'a']-- == 0) return false;
        }
        
        return true;
    }
}