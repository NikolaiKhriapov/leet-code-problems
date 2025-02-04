class Solution {
    public boolean isAnagram(String s, String t) {
        int[] array = new int[27];
        
        for (char c : s.toCharArray()) {
            array[c - 'a' + 1]++;
        }
        for (char c : t.toCharArray()) {
            array[c - 'a' + 1]--;
        }

        for (int n : array) {
            if (n != 0) {
                return false;
            }
        }

        return true;
    }
}