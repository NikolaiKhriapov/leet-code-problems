class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        char[] freqArray = new char[26];
        for (char c : magazine.toCharArray()) {
            freqArray[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (freqArray[c - 'a'] <= 0) {
                return false;
            }
            freqArray[c - 'a']--;
        }

        return true;
    }
}

// time. - O(n + m)
// space - O(1)