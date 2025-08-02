class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (s.length() != t.length()) {
            return false;
        }

        int[] freqArray = new int[256];
        for (char c : s.toCharArray()) {
            freqArray[c]++;
        }
        for (char c : t.toCharArray()) {
            freqArray[c]--;
            if (freqArray[c] < 0) {
                return false;
            }
        }
        return true;
    }
}

// time. - O(n)
// space - O(1)