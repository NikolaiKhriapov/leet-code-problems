class Solution {
    public int firstUniqChar(String s) {
        int[] array = new int[26];

        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}